package com.joonfluence.starbucks.domain.user.customer.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * 유저 정보 조회 AOP
 *
 * @author : joonho
 * @fileName : CurrentUserCheckAspect
 * @since : 2023/12/05
 */

@Aspect
@Component
public class CurrentUserCheckAspect {
    @Pointcut("execution(* com.joonfluence.starbucks..*(..)) && @annotation(com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck)")
    private void currentUserCheck() {}

    @Around("currentUserCheck()")
    public void execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Object target = joinPoint.getTarget();
        // Get the method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // Get the method object
        Method method = signature.getMethod();
        // Get the parameter annotations
        Annotation[][] annotations = method.getParameterAnnotations();
        // get Userid
        long userId = getUserId();
        // Iterate over the annotations
        for (int i = 0; i < annotations.length; i++) {
            for (Annotation annotation : annotations[i]) {
                // Check if the annotation is @CurrentUser
                if (annotation instanceof CurrentUser) {
                    // Change the Parameter Value
                    method.invoke(target, userId);
                }
            }
        }

        joinPoint.proceed();
    }

    private static long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("SecurityContext에 인증 정보가 없습니다.");
        }
        return Long.parseLong(authentication.getName());
    }
}
