package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dto.RemotecontrollerDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.service.RemotecontrollerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RemotecontrollerController {

    private final RemotecontrollerService service;
    public RemotecontrollerController( RemotecontrollerService service ) {
        this.service = service;
    }


    @GetMapping("/rc")
    public ResponseEntity<Object> getAllRemotecontrollers() {
        List<RemotecontrollerDto> lrc = service.getAllRemotecontrollers();

        return new ResponseEntity<>( lrc, HttpStatus.OK );
    }

    @GetMapping("/rc/{id}")
    public ResponseEntity<Object> getRemotecontrollerById( @PathVariable(name = "id") Long id ) {
        RemotecontrollerDto rc = service.getRemotecontrollerById( id );
        try {
            return ResponseEntity.ok( rc );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    @PostMapping("/rc")
    public ResponseEntity<Object> addRemotecontroller( @Valid @RequestBody RemotecontrollerDto remotecontrollerDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            service.addRemotecontroller( remotecontrollerDto );
            return new ResponseEntity( "Remote Controller is aangemaakt", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/rc/{id}")
    public void deleteCiModuleById( @PathVariable("id") Long id ) {

        service.deleteRemotecontrollerById( id );

    }

    @PutMapping("rc/{id}")
    public RemotecontrollerDto updateCiModule( @PathVariable("id") Long id, @RequestBody RemotecontrollerDto remoteController ) {

        RemotecontrollerDto dto = service.updateRemotecontroller( id, remoteController );

        return dto;

    }
}


