package com.infoacademy.infoacademy.controllers;

import com.infoacademy.infoacademy.domaine.dtos.auth.*;
import com.infoacademy.infoacademy.domaine.entities.Student;
import com.infoacademy.infoacademy.domaine.mappers.AuthMapper;
import com.infoacademy.infoacademy.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthMapper mapper;
    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<Void> studentRegister(@Valid @RequestBody StudentRegisterRequest studentRegisterRequest) {
        Student newStudent = mapper.toStudentEntity(studentRegisterRequest);
        service.studentRegister(newStudent);
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    @PostMapping
    public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest authRequest){
        UserDetails userDetails = service.authenticate(authRequest.getEmail(), authRequest.getPassword());
        String token = service.generateToken(userDetails);
        AuthResponse authResponse = AuthResponse.builder().token(token).build();
        return ResponseEntity.ok(authResponse);
    }

}
