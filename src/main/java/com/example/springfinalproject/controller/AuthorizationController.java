package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.LoginDto;
import com.example.springfinalproject.dto.RegisterDto;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.entity.Role;
import com.example.springfinalproject.repository.OrganisationRepository;
import com.example.springfinalproject.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/authorisation")
public class AuthorizationController {
    private final AuthenticationManager authenticationManager;
    private final OrganisationRepository organisationRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthorizationController(AuthenticationManager authenticationManager, OrganisationRepository organisationRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.organisationRepository = organisationRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        Authentication authorization = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getLoginPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authorization);
        return new ResponseEntity<>("Organisation/User signed-in successfully", HttpStatus.OK);
    }

    @PostMapping(value = {"/register"})
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        if (organisationRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>("this Mail is already used in our database", HttpStatus.OK);
        }
        if (organisationRepository.existsByName(registerDto.getName())) {
            return new ResponseEntity<>("this name of a firm is already taken", HttpStatus.OK);
        }
        Organisation organisation = new Organisation();
        organisation.setName(registerDto.getName());
        organisation.setNip(registerDto.getNip());
        organisation.setEmail(registerDto.getEmail());
        organisation.setLoginPassword(passwordEncoder.encode(registerDto.getLoginPassword()));
        Role roles = roleRepository.findByName("ADMIN").get();
       // organisation.setRoles(Collections.singleton(roles));
        organisationRepository.save(organisation);
        return new ResponseEntity<>("Organisation registered successfully", HttpStatus.OK);
    }
}
