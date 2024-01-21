package com.malexj.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

//  @Pointcut(
//          value =
//                  "execution(* com.malexj.service.BookService.find*(..)) & execution(* com.malexj.service.BookService.add*(..))")
  @Pointcut(value = "execution(* com.malexj.service.BookService.find*(..))")
  public void allFindMethods() {}
}