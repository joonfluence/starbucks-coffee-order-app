package com.joonfluence.starbucks.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonfluence.starbucks.global.dto.ErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    /*

    실제 필터링 로직은 doFilterInternal 에 들어감
    JWT 토큰의 인증 정보를 현재 쓰레드의 SecurityContext 에 저장하는 역할 수행

     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // 1. Request Header 에서 토큰을 꺼냄
        String token = jwtService.resolveToken(request);

        try {
            // 2. validateToken 으로 토큰 유효성 검사
            if (StringUtils.hasText(token) && jwtService.validateToken(token)) {
                // 3. 정상 토큰이면 해당 토큰으로 Authentication 을 가져와서 SecurityContext 에 저장
                Authentication authentication = jwtService.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            // 4. 다음 단계로 넘김
            filterChain.doFilter(request, response);
        } catch (RuntimeException e) {
            // 5. 에러 반환
            ObjectMapper objectMapper = new ObjectMapper();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(objectMapper.writeValueAsString(new ErrorResponse(401, e.getMessage())));
        }
    }
}