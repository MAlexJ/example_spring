package com.malexj.advanced.custom_annotation.aspect;

import com.malexj.base.AbstractClass;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect extends AbstractClass {

  @Pointcut("@annotation(com.malexj.advanced.custom_annotation.annotation.MyTransaction)")
  public void serviceMethod() {}

  @Before("serviceMethod()")
  public void serviceAdvice() {
    println("1. Aspect");
  }
}
