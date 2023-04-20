package com.example.springfinalproject.service;

import com.example.springfinalproject.dto.LoginDto;
import com.example.springfinalproject.dto.RegisterDto;

public interface AuthorizationService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
