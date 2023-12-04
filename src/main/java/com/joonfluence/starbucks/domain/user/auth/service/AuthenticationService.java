package com.joonfluence.starbucks.domain.user.auth.service;

import com.joonfluence.starbucks.domain.user.auth.config.JwtService;
import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.exception.DuplicateUserEmailException;
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public Long register(RegisterRequest request) {
        validateByEmail(request.getEmail());
        Customer customer = request.toEntity();
        customer.updatePassword(passwordEncoder.encode(customer.getPassword()));
        Customer saved = repository.save(customer);
        return saved.getId();
    }

    public AuthenticationResponse logIn(LoginRequest request) {
        Authentication authentication = authenticateLoginRequest(request);
        return jwtService.generateToken(authentication);
    }

    private Authentication authenticateLoginRequest(LoginRequest request) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
    }

    private void validateByEmail(String email) {
        if(repository.existsByEmail(email)){
            throw new DuplicateUserEmailException("이미 중복된 이메일이 존재합니다");
        }
    }
}
