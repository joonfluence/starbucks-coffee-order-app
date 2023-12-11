package com.joonfluence.starbucks.domain.user.auth.service;

import com.joonfluence.starbucks.domain.user.auth.entity.RefreshToken;
import com.joonfluence.starbucks.domain.user.auth.repository.RefreshTokenRepository;
import com.joonfluence.starbucks.global.utils.UuidGenerator;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RefreshTokenService {
    private final RefreshTokenRepository repository;

    public RefreshTokenService(RefreshTokenRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public String generateRefreshToken(){
        String generated = UuidGenerator.generate();
        RefreshToken refreshToken = RefreshToken.builder().uuid(generated).build();
        repository.save(refreshToken);
        return refreshToken.getUuid();
    }

    public String checkRefreshToken(String uuid){
        // 1) 존재하지 않거나 만료된 경우
        RefreshToken token = repository.findById(uuid).orElseThrow(() -> new JwtException("해당 토큰은 존재하지 않거나 만료됐습니다."));
        return token.getUuid();
    }
}
