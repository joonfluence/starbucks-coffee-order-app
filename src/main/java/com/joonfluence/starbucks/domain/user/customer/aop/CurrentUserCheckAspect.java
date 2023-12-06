package com.joonfluence.starbucks.domain.user.customer.aop;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> cb9e8d5 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
>>>>>>> 2a88bff (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
=======
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
<<<<<<< HEAD
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
>>>>>>> 25f8286 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
>>>>>>> bbf437a (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
<<<<<<< HEAD
>>>>>>> cb9e8d5 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
=======
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
>>>>>>> 2134f5b (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 2a88bff (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.lang.reflect.InvocationTargetException;
=======
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
import java.lang.reflect.InvocationTargetException;
>>>>>>> 25f8286 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
import java.lang.reflect.InvocationTargetException;
=======
>>>>>>> bbf437a (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> cb9e8d5 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
import java.lang.reflect.InvocationTargetException;
=======
>>>>>>> bbf437a (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
import java.lang.reflect.InvocationTargetException;
>>>>>>> 2134f5b (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 2a88bff (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    @Pointcut("@annotation(com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck)")
=======
    @Pointcut("execution(* com.joonfluence.starbucks..*(..)) && @annotation(com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck)")
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
    @Pointcut("@annotation(com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck)")
>>>>>>> 25f8286 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
=======
>>>>>>> 2a88bff (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
    @Pointcut("@annotation(com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck)")
=======
    @Pointcut("execution(* com.joonfluence.starbucks..*(..)) && @annotation(com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck)")
>>>>>>> bbf437a (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
<<<<<<< HEAD
>>>>>>> cb9e8d5 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
=======
    @Pointcut("@annotation(com.joonfluence.starbucks.domain.user.customer.aop.CurrentUserCheck)")
>>>>>>> 2134f5b (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 2a88bff (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
    private void currentUserCheck() {}

    @Around("currentUserCheck()")
    public void execute(ProceedingJoinPoint joinPoint) throws Throwable {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 25f8286 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
>>>>>>> cb9e8d5 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
=======
>>>>>>> 2134f5b (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 2a88bff (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
        setUserId(joinPoint, getUserId());
        joinPoint.proceed();
    }

    private static void setUserId(ProceedingJoinPoint joinPoint, Long userId) throws IllegalAccessException, InvocationTargetException {
        if (userId == null) return;
        // System.out.println("[CurrentUserCheckAspect.setUserId] userId =" + userId);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
>>>>>>> 25f8286 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
=======
>>>>>>> bbf437a (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> cb9e8d5 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
=======
>>>>>>> bbf437a (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
>>>>>>> 2134f5b (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 2a88bff (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
        Object target = joinPoint.getTarget();
        // Get the method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // Get the method object
        Method method = signature.getMethod();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> cb9e8d5 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
>>>>>>> 2a88bff (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
        // Change the Parameter Value
        method.invoke(target, userId);
=======
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
<<<<<<< HEAD
>>>>>>> 0dbc7f4 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
        // Change the Parameter Value
        method.invoke(target, userId);
>>>>>>> 25f8286 (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
>>>>>>> bbf437a (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
<<<<<<< HEAD
>>>>>>> cb9e8d5 (feat(Auth) : AOP 활용하여 로그인한 User Id 확인)
=======
=======
        // Change the Parameter Value
        method.invoke(target, userId);
>>>>>>> 2134f5b (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
>>>>>>> 2a88bff (refactor(Auth) : AOP 활용하여 로그인한 User Id 확인)
    }

    private static long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("SecurityContext에 인증 정보가 없습니다.");
        }
        return Long.parseLong(authentication.getName());
    }
}
