package com.joonfluence.starbucks.domain.user.auth.dto.response;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private String refreshTokenUUid;
=======
=======
>>>>>>> 3d44ca5 (feat(Auth) : Redis에 RefreshToken 정보 저장)
=======
>>>>>>> c7ac17d (feat(Auth) : Redis에 RefreshToken 정보 저장)
    private String refreshToken;
=======
public class AuthenticationResponse {
>>>>>>> 806e707 ([FEAT] Jwt Util 함수 구현 및 JwtAuthenticationFilter 적용)
<<<<<<< HEAD
>>>>>>> 4fad24b ([FEAT] Jwt Util 함수 구현 및 JwtAuthenticationFilter 적용)
=======
=======
    private String refreshTokenUUid;
>>>>>>> 65b46f1 (feat(Auth) : Redis에 RefreshToken 정보 저장)
<<<<<<< HEAD
>>>>>>> 3d44ca5 (feat(Auth) : Redis에 RefreshToken 정보 저장)
=======
=======
    private String refreshTokenUUid;
>>>>>>> c8aa812 (feat(Auth) : Redis에 RefreshToken 정보 저장)
>>>>>>> c7ac17d (feat(Auth) : Redis에 RefreshToken 정보 저장)
}
