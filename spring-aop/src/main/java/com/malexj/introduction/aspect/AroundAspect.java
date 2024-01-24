package com.malexj.introduction.aspect;

import com.malexj.base.AbstractClass;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect extends AbstractClass {

  @Around("com.malexj.introduction.pointcut.AroundPointcut.getBookMethod()")
  public void getBookAdvice(ProceedingJoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    println("method:", signature.getMethod());
  }

  @Around("com.malexj.introduction.pointcut.AroundPointcut.returnBookMethod()")
  public Object returnBookAdvice(ProceedingJoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    println("method:", signature.getMethod());
    try {
      return joinPoint.proceed();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }

  @Around("com.malexj.introduction.pointcut.AroundPointcut.returnBookThrowingExceptionMethod()")
  public Object returnBookTrowingExceptionAdvice(ProceedingJoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    println("method:", signature.getMethod());
    try {
      return joinPoint.proceed();
    } catch (Throwable e) {
      return "Default";
    }
  }
}
