package com.example.helloworld.service;

import com.example.helloworld.dto.request.SignUpRequest;
import com.example.helloworld.dto.request.SigninRequest;
import com.example.helloworld.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
