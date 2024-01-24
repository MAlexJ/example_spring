package com.malexj.introduction.aop.afterThrowing;

import org.aspectj.lang.annotation.Pointcut;

public class AfterThrowingPointcut {

  @Pointcut("execution(* com.malexj.introduction.bean.Student.*(..))")
  public void studentMethods() {}
}
