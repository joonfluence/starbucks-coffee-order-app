package com.joonfluence.starbucks.domain.user.auth.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@Getter
@RedisHash(value = "refresh", timeToLive = 604800000)
public class RefreshToken {
    @Id
    private String uuid;

    @Builder
    public RefreshToken(String uuid) {
        this.uuid = uuid;
    }
}
