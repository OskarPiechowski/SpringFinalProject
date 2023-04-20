package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.JwtAuthorizationDto;
import com.example.springfinalproject.dto.LoginDto;
import com.example.springfinalproject.dto.RegisterDto;
import com.example.springfinalproject.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthorizationController {

    private AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }
    @PostMapping("api/organisation/login")
    public ResponseEntity<JwtAuthorizationDto> login(@RequestBody LoginDto loginDto){
        String token = authorizationService.login(loginDto);
        JwtAuthorizationDto jwtAuthorizationDto = new JwtAuthorizationDto();
        jwtAuthorizationDto.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthorizationDto);
    }

    @PostMapping(value = {"/organisation/register"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authorizationService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
