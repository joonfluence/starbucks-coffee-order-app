package com.joonfluence.starbucks.global.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * 유저 정보 조회 AOP
 *
 * @author : joonho
 * @fileName : CurrentUserAspect
 * @since : 2023/12/05
 */

@Aspect
// @Component
public class CurrentUser {
    @Around("execution(* com.joonfluence.starbucks..*(..))")
    public Long execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            joinPoint.proceed();
        } finally {
            if (authentication == null || authentication.getName() == null) {
                throw new RuntimeException("Security Context 에 인증 정보가 없습니다.");
            }
            System.out.println("Long.parseLong(authentication.getName()) = " + Long.parseLong(authentication.getName()));
            return Long.parseLong(authentication.getName());
        }
    }
}
