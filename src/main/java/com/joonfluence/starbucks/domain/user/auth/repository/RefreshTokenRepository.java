package com.joonfluence.starbucks.domain.user.auth.repository;

import com.joonfluence.starbucks.domain.user.auth.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findById(String uuid);
}
