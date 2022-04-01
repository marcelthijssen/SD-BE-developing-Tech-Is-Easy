package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dto.UserDto;
import nl.novi.techiteasy1121.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    JwtService jwtService;

    @PostMapping("/auth")
    public ResponseEntity<Object> signIn( @RequestBody UserDto userDto ) {
        UsernamePasswordAuthenticationToken up = new UsernamePasswordAuthenticationToken( userDto.getUsername(), userDto.getPassword() );
        Authentication auth = authManager.authenticate( up );

        UserDetails ud = ( UserDetails ) auth.getPrincipal();
        String token = jwtService.generateToken( ud );
        return ResponseEntity.ok()
                .header( HttpHeaders.AUTHORIZATION, "Bearer " + token )
                .body( "Token generated " + token );
    }
}
