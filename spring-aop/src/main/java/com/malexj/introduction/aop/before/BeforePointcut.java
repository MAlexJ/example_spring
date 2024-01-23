package com.malexj.introduction.aop.before;

import com.malexj.introduction.annotation.MyAnnotation;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class BeforePointcut {

  @Pointcut("execution(* com.malexj.introduction.bean.Shop.info(..))")
  public void shopInfoMethods() {}

  @Pointcut("@annotation(myAnnotation)")
  public void shopAddInfoMethods(MyAnnotation myAnnotation) {}
}
