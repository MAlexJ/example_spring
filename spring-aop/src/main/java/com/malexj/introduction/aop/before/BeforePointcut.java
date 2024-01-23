package com.malexj.introduction.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Pointcuts {

  @Pointcut("execution(* com.malexj.introduction.bean.Shop.info(..))")
  public void userInfoMethods() {}
}
