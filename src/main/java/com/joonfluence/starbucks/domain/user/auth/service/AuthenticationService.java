package com.joonfluence.starbucks.domain.user.auth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonfluence.starbucks.domain.user.auth.config.JwtService;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService { }
