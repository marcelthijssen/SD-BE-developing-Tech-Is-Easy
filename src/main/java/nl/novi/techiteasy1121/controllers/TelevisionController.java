package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dto.IdInputDto;
import nl.novi.techiteasy1121.dto.TelevisionDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.service.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TelevisionController {

    private final TelevisionService tvService;

    public TelevisionController( TelevisionService tvService ) {
        this.tvService = tvService;
    }

    @GetMapping("/televisions")
    public ResponseEntity<Object> getAllTelevisions() {
        List<TelevisionDto> lt = tvService.getAllTelevisions();

        return new ResponseEntity<>( lt, HttpStatus.OK );
    }

    // changed <TelevisionDto> to <Object>
    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevisionById( @PathVariable(name = "id") Long id ) {
        TelevisionDto tv = tvService.getTelevisionById( id );
        try {
            return ResponseEntity.ok( tv );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    //    Check if television type is allready in db, if so do nothing and reply is already in db
    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision( @Valid @RequestBody TelevisionDto televisionDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            tvService.addTelevision( televisionDto );
            return new ResponseEntity( "Televisie aangemaakt", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/televisions/{id}")
    public void deleteTelevisionById( @PathVariable("id") Long id ) {

        tvService.deleteTelevisionById( id );

    }

    @PutMapping("televisions/{id}")
    public TelevisionDto updateTelevision( @PathVariable("id") Long id, @RequestBody TelevisionDto television ) {

        TelevisionDto dto = tvService.updateTelevision( id, television );

        return dto;

    }

    //    //    class relationship
    @PutMapping("/televisions/{tvid}/{rcid}")
    public ResponseEntity<Object> assignRemotecontrollerToTelevision( @PathVariable("tvid") Long id, @PathVariable("rcid") Long remotecontrollerId ) {

        tvService.assignRemotecontrollerToTelevision( id, remotecontrollerId );
        return new ResponseEntity<>( "rc gekoppeld aan tv", HttpStatus.ACCEPTED );
    }

}