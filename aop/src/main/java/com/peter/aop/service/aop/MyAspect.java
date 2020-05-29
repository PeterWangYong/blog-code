package com.peter.aop.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
  @Around("execution(* *..UserServiceImpl.*(..))")
  public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("--- log before ---");
    Object ret = joinPoint.proceed();
    System.out.println("--- log after ---");
    return ret;
  }

  @Around("@annotation(com.peter.aop.annotation.Tx)")
  public Object tx(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("--- tx before ---");
    Object ret = joinPoint.proceed();
    System.out.println("--- tx after ---");
    return ret;
  }
}
