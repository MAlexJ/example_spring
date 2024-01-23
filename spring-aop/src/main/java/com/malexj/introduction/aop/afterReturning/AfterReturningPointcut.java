package com.malexj.introduction.aop.afterReturning;

import org.aspectj.lang.annotation.Pointcut;

public class AfterReturningPointcut {

  @Pointcut("execution(* sayMay())")
  public void sayMayMethods() {}


  @Pointcut("execution(* bark())")
  public void barkMethods() {}
}
