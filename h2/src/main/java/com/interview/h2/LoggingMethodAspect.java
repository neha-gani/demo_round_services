package com.interview.h2;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingMethodAspect
{
//    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Around("execution(* com.interview.h2..*(..)))")
    public Object logMethodDetails(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        log.info("Entering class {} \tmethod {} \twith params {}", className, methodName, proceedingJoinPoint.getArgs());
        Object result = proceedingJoinPoint.proceed();
        return result;
    }
}