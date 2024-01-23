package com.malexj.introduction.aop.after;

import org.aspectj.lang.annotation.Pointcut;

public class AfterPointcut {

  @Pointcut("execution(* getStudent*(..))")
  public void getStudentsMethods() {}
}
