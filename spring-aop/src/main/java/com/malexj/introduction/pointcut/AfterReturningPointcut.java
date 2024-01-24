package com.malexj.introduction.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class AfterReturningPointcut {

  @Pointcut("execution(* sayMay())")
  public void sayMayMethods() {}


  @Pointcut("execution(* bark())")
  public void barkMethods() {}
}
