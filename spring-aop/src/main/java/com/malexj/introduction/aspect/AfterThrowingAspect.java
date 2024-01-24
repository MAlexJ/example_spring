package com.malexj.introduction.aspect;

import com.malexj.base.AbstractClass;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAspect extends AbstractClass {

  @AfterThrowing(
      pointcut = "com.malexj.introduction.pointcut.AfterThrowingPointcut.studentMethods()",
      throwing = "error")
  public void studentAfterThrowingAdvice(JoinPoint joinPoint, Throwable error) {
    println("1.1.", "Signature:", joinPoint.getSignature().getName());
    println("1.2.", "Exception with message:", error);
  }
}
