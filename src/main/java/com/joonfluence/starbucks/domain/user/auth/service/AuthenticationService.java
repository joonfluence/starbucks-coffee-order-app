package com.joonfluence.starbucks.domain.user.auth.service;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.joonfluence.starbucks.domain.user.auth.dto.response.RefreshTokenRequestDto;
=======
<<<<<<< HEAD
>>>>>>> 4fad24b ([FEAT] Jwt Util 함수 구현 및 JwtAuthenticationFilter 적용)
=======
<<<<<<< HEAD
>>>>>>> 609dc55 ([FEAT] 회원가입 기능 구현)
=======
<<<<<<< HEAD
=======
import com.joonfluence.starbucks.domain.user.auth.dto.response.RefreshTokenRequestDto;
>>>>>>> 65b46f1 (feat(Auth) : Redis에 RefreshToken 정보 저장)
>>>>>>> 3d44ca5 (feat(Auth) : Redis에 RefreshToken 정보 저장)
import com.joonfluence.starbucks.domain.user.auth.dto.response.RegisterResponse;
import com.joonfluence.starbucks.global.security.JwtService;
=======
import com.joonfluence.starbucks.domain.user.auth.config.JwtService;
>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
import com.joonfluence.starbucks.domain.user.auth.dto.request.LoginRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.request.RegisterRequest;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
import com.joonfluence.starbucks.domain.user.auth.exception.DuplicateUserEmailException;
<<<<<<< HEAD
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.apache.catalina.core.ApplicationContext;
>>>>>>> 2e820e8 (feat(Auth) : 로그인 기능 구현)
=======
>>>>>>> 8d31ae2 (feat(Auth) : 리프레쉬 토큰 및 토큰 Response 구현)
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final CustomerRepository repository;
    private final RefreshTokenService refreshTokenService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
<<<<<<< HEAD

    @Transactional
    public RegisterResponse register(RegisterRequest request) {
        validateByEmail(request.getEmail());
        Customer customer = request.toEntity();
        customer.updatePassword(passwordEncoder.encode(customer.getPassword()));
        Customer saved = repository.save(customer);
        return new RegisterResponse(saved.getId(), saved.getNickName(), saved.getEmail());
    }

    public AuthenticationResponse logIn(LoginRequest request) {
        Authentication authentication = authenticateLoginRequest(request);
        return jwtService.generateToken(authentication);
    }

    public AuthenticationResponse refreshToken(RefreshTokenRequestDto dto) {
        refreshTokenService.checkRefreshToken(dto.getRefreshToken());
        Customer customer = repository.findByEmail(dto.getUserEmail()).orElseThrow(() -> new NoSuchElementException("그런 유저는 없습니다"));
        return jwtService.generateToken(customer);
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
=======
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonfluence.starbucks.domain.user.auth.config.JwtService;
import com.joonfluence.starbucks.domain.user.auth.dto.response.AuthenticationResponse;
=======
>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
import com.joonfluence.starbucks.domain.user.customer.entity.Customer;
import com.joonfluence.starbucks.domain.user.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
=======
import lombok.extern.slf4j.Slf4j;
>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService { }
>>>>>>> 806e707 ([FEAT] Jwt Util 함수 구현 및 JwtAuthenticationFilter 적용)
=======
@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
=======
>>>>>>> 2e820e8 (feat(Auth) : 로그인 기능 구현)

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

    public AuthenticationResponse refreshToken(HttpServletRequest request) {
        String resolveToken = jwtService.resolveToken(request);
        String userEmail = jwtService.extractUsername(resolveToken);
        Customer customer = repository.findById(Long.parseLong(userEmail)).orElseThrow();
        jwtService.validateToken(resolveToken);
        return jwtService.generateToken(customer);
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
>>>>>>> edd2b22 ([FEAT] 회원가입 기능 구현)
