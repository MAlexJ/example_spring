package com.malexj.aop;

import com.malexj.base.AbstractClass;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspects extends AbstractClass {

  @Before("com.malexj.aop.Pointcuts.userInfoMethods()")
  public void aroundAdvice(JoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    println(signature.getReturnType());
    println(signature.getMethod());
  }
}
