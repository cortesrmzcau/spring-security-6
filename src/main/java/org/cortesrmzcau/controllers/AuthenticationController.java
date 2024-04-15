package org.cortesrmzcau.controllers;

import lombok.AllArgsConstructor;
import org.cortesrmzcau.models.entity.JwtRequest;
import org.cortesrmzcau.models.entity.JwtResponse;
import org.cortesrmzcau.services.JwtService;
import org.cortesrmzcau.services.JwtUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtUserDetails jwtUserDetails;
    private final JwtService jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> postToken(@RequestBody JwtRequest jwtRequest) {
        this.authenticate(jwtRequest);

        final var userDetails = this.jwtUserDetails.loadUserByUsername(jwtRequest.getUsername());
        final var token = this.jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(JwtRequest jwtRequest) {
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        }
        catch (BadCredentialsException | DisabledException badCredentialsException) {
            throw new BadCredentialsException(badCredentialsException.getMessage());
        }
    }
}
