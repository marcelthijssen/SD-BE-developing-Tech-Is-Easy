package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dto.CiModuleDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.service.CiModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CiModuleController {

    private final CiModuleService service;
    public CiModuleController( CiModuleService service ) {
        this.service = service;
    }


    @GetMapping("/cimodules")
    public ResponseEntity<Object> getAllCiModules() {
        List<CiModuleDto> lcm = service.getAllCiModules();

        return new ResponseEntity<>( lcm, HttpStatus.OK );
    }
    //
//    @GetMapping("/televisions/{id}")
//    public ResponseEntity<Object> getTelevisionById( @PathVariable(name = "id") Long id ) {
//        Television tv = service.getTelevisionById( id );
//        if ( tv != null ) {
//            return new ResponseEntity<>( tv, HttpStatus.OK );
//        } else {
//            return new ResponseEntity<>( "id Not Found", HttpStatus.NOT_FOUND );
//        }
//    }
// changed <TelevisionDto> to <Object>
    @GetMapping("/cimodules/{id}")
    public ResponseEntity<Object> getCiModuleById( @PathVariable(name = "id") Long id ) {
        CiModuleDto tv = service.getCiModuleById( id );
        try {
            return ResponseEntity.ok(tv);
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    @PostMapping("/cimodules")
    public ResponseEntity<Object> addCiModule( @Valid @RequestBody CiModuleDto ciModuleDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            service.addCiModule( ciModuleDto );
            return new ResponseEntity( "CI-Module is aangemaakt", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/cimodules/{id}")
    public void deleteCiModuleById(@PathVariable("id") Long id) {

        service.deleteCiModuleById(id);

    }

    @PutMapping("cimodules/{id}")
    public CiModuleDto updateCiModule(@PathVariable("id") Long id, @RequestBody CiModuleDto ciModule) {

        CiModuleDto dto = service.updateCiModule(id, ciModule);

        return dto;

    }
}

