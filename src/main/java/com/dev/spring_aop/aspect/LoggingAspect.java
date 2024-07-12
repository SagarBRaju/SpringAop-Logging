package com.dev.spring_aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.dev.spring_aop.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before : " + String.valueOf(joinPoint.getSignature()));
    }

    @After("execution(*com.dev.spring_aop.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("After : " + String.valueOf(joinPoint.getSignature()));
    }

    @AfterReturning(pointcut = "execution(* com.dev.spring_aop.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("After Returning : " + String.valueOf(joinPoint.getSignature()) + result.toString());
    }

    @AfterThrowing(pointcut = "execution(* com.dev.spring_aop.service.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.info("After Throwing : " + String.valueOf(joinPoint.getSignature() + error.getMessage()));
    }

    @Around("execution(* com.dev.spring_aop.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // Proceed with method execution

        long endTime = System.currentTimeMillis();
        String executionTime = String.valueOf(endTime - startTime);

        logger.info("Executed in  " + executionTime + "ms");

        return result;
    }
}
