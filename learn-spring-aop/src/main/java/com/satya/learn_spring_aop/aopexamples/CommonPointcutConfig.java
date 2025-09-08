package com.satya.learn_spring_aop.aopexamples;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.satya.learn_spring_aop..*(..))")
    public void allMethodCalls() {}

    @Pointcut("@annotation(com.satya.learn_spring_aop.annotations.TrackTime)")
    public void trackTime(){}
}
