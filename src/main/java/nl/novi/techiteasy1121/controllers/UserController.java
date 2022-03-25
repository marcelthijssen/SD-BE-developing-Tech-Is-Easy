package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dto.TelevisionDto;
import nl.novi.techiteasy1121.dto.UserDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class UserController {

    private final UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        List<UserDto> lt = userService.getAllUsers();

        return new ResponseEntity<>( lt, HttpStatus.OK );
    }

    // changed <TelevisionDto> to <Object>
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getTelevisionById( @PathVariable(name = "id") Long id ) {
        UserDto tv = userService.getUserById( id );
        try {
            return ResponseEntity.ok( tv );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addTelevision( @Valid @RequestBody UserDto userDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            userService.addUser( userDto );
            return new ResponseEntity( "Televisie aangemaakt", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteTelevisionById( @PathVariable("id") Long id ) {

        userService.deleteUserById( id );

    }

    @PutMapping("users/{id}")
    public UserDto updateUser( @PathVariable("id") Long id, @RequestBody UserDto user ) {

        UserDto dto = userService.updateUser( id, user );

        return dto;

    }

}
