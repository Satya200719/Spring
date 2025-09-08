package com.satya.learn_spring_aop.aopexamples;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AOPConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.satya.learn_spring_aop.aopexamples.CommonPointcutConfig.allMethodCalls()")
    public void logMethodCalls(JoinPoint joinPoint){
        logger.info("Before aspect point cut -> Message -> {} ", joinPoint);
    }

    @Around("com.satya.learn_spring_aop.aopexamples.CommonPointcutConfig.trackTime()")
    public Object performanceTracking(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();

        Object value = proceedingJoinPoint.proceed();
        Long stopTime = System.currentTimeMillis();

        Long timeDiff = stopTime - startTime;

        logger.info("Time taken by method - {} is {}", proceedingJoinPoint, timeDiff);
        return value;
    }
}
