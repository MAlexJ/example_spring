package com.malexj.introduction.aop.after;

import com.malexj.base.AbstractClass;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAspect extends AbstractClass {

  @After("com.malexj.introduction.aop.after.AfterPointcut.getStudentsMethods()")
  public void getStudentsAdvice(JoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    println("method", signature.getMethod(), ", after work!");
  }
}
