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
    private String refreshTokenUUid;
=======
    private String refreshToken;
=======
public class AuthenticationResponse {
>>>>>>> 806e707 ([FEAT] Jwt Util 함수 구현 및 JwtAuthenticationFilter 적용)
>>>>>>> 4fad24b ([FEAT] Jwt Util 함수 구현 및 JwtAuthenticationFilter 적용)
}
