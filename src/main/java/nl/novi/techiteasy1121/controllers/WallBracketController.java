package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dto.WallBracketDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.service.WallBracketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WallBracketController {

    private final WallBracketService service;
    public WallBracketController( WallBracketService service ) {
        this.service = service;
    }


    @GetMapping("/wallbrackets")
    public ResponseEntity<Object> getAllWallBracket() {
        List<WallBracketDto> lwb = service.getAllWallBrackets();

        return new ResponseEntity<>( lwb, HttpStatus.OK );
    }
    @GetMapping("/WallBrackets/{id}")
    public ResponseEntity<Object> getWallBracketById( @PathVariable(name = "id") Long id ) {
        WallBracketDto tv = service.getWallBracketById( id );
        try {
            return ResponseEntity.ok(tv);
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    @PostMapping("/wallbrackets")
    public ResponseEntity<Object> addWallBracket( @Valid @RequestBody WallBracketDto wallBracketDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            service.addWallBracket( wallBracketDto );
            return new ResponseEntity( "Wallbracket aangemaakt", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/wallbrackets/{id}")
    public void deleteWallBracketById(@PathVariable("id") Long id) {

        service.deleteWallBracketById(id);

    }

    @PutMapping("WallBrackets/{id}")
    public WallBracketDto updateWallBracket(@PathVariable("id") Long id, @RequestBody WallBracketDto wallBracket) {

        WallBracketDto dto = service.updateWallBracket(id, wallBracket);

        return dto;

    }

}
