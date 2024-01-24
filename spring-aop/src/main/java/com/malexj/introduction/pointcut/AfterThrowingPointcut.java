package com.malexj.introduction.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class AfterThrowingPointcut {

  @Pointcut("execution(* com.malexj.introduction.bean.Student.*(..))")
  public void studentMethods() {}
}
