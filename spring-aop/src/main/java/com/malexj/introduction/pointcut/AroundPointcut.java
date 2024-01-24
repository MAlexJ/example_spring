package com.malexj.introduction.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class AroundPointcut {

  @Pointcut("execution(* com.malexj.introduction.bean.UniversityLibrary.getBook(..))")
  public void getBookMethod() {}

  @Pointcut("execution(* com.malexj.introduction.bean.UniversityLibrary.returnBook(..))")
  public void returnBookMethod() {}


  @Pointcut("execution(* com.malexj.introduction.bean.UniversityLibrary.returnBookThrowingException(..))")
  public void returnBookThrowingExceptionMethod(){}

}
