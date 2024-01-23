package com.malexj.introduction.aop.before;

import com.malexj.base.AbstractClass;
import com.malexj.introduction.annotation.MyAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 1. Before advice: <br>
 * <br>
 * - Executed before the target method. <br>
 * - Commonly used for logging, security checks, and setup actions.
 */
@Aspect
@Component
public class BeforeAspect extends AbstractClass {

  /** Before Advice */
  @Before("com.malexj.introduction.aop.before.BeforePointcut.shopInfoMethods()")
  public void beforeShopAdvice(JoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    println(signature.getReturnType());
    println(signature.getMethod());
  }

  @Before(
      value = "com.malexj.introduction.aop.before.BeforePointcut.shopAddInfoMethods( myAnnotation)",
      argNames = "joinPoint,myAnnotation")
  public void beforeAnnotationShopAdvice(JoinPoint joinPoint, MyAnnotation myAnnotation) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    println("method:", signature.getMethod());
    println("return type:", signature.getReturnType());

    println("Annotation value:", myAnnotation.name());
  }
}
