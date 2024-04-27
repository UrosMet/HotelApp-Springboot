package com.metropolitan.it355.controller;

import com.metropolitan.it355.authentication.AuthenticationService;
import com.metropolitan.it355.dto.LoginDTO;
import com.metropolitan.it355.dto.LoginResponse;
import com.metropolitan.it355.entity.Recepcioner;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginResponseResponseEntity(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(authenticationService.login(loginDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> registerResponseResponseEntity(@RequestBody Recepcioner recepcioner){
        return ResponseEntity.ok(authenticationService.register(recepcioner));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader(value = "Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            authenticationService.logout(token);
            return ResponseEntity.ok("Logged out successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid authorization header.");
        }
    }




}
