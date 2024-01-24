package com.malexj.introduction.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

  @Pointcut(
      "execution(* com.malexj.service.BookService.find*(..)) "
          + "|| execution(* com.malexj.service.BookService.add*(..))")
  public void allPublicServiceMethods() {}
}
