package com.malexj.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Pointcuts {

  @Pointcut("execution(* com.malexj.bean.User.info(..))")
  public void userInfoMethods() {}
}
