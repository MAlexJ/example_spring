package com.malexj.introduction.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class AfterPointcut {

  @Pointcut("execution(* getStudent*(..))")
  public void getStudentsMethods() {}
}
