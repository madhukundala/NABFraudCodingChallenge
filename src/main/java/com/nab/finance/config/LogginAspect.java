package com.nab.finance.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

///@Aspect
//@Component
public class LogginAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.nab.finance.controller.*.*(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        logger.debug("action=\"Enter\", method_name=\"{}\" " + methodName, joinPoint.getSignature().getName());
    }


    //Weaving & Weaver
    @Around("execution(* com.nab.finance.controller.*.*(..))")
    public void aroundTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        joinPoint.proceed();
        logger.info("Time Taken by {} is {}", methodName, System.currentTimeMillis() - start);

    }

    @AfterReturning(value = "execution(* com.nab.finance.controller.*.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        logger.debug("action=\"Exit\", method_name=\"{}\" " + methodName, joinPoint.getSignature().getName());
    }


    @AfterThrowing(pointcut = "execution(* com.nab.finance.controller.*.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
        logger.error("Exception at method_name=\"{}\" " + ex.getClass().getName(), ex.getCause());
    }
}
