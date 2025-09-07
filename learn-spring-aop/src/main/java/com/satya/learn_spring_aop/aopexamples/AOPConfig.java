package com.satya.learn_spring_aop.aopexamples;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AOPConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution (* com.satya.learn_spring_aop.*.*.*.* (..))")
    public void logMethodCalls(JoinPoint joinPoint){
        logger.info("Before aspect point cut -> Message -> {} ", joinPoint);
    }
}
