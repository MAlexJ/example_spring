package com.malexj.introduction.aspect;

import com.malexj.base.AbstractClass;
import com.malexj.introduction.bean.Cat;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAspect extends AbstractClass {

  @AfterReturning(
      "com.malexj.introduction.pointcut.AfterReturningPointcut.sayMayMethods()")
  public void mayAfterReturningAdvice() {
    println("May!!!");
  }

  @AfterReturning(
      pointcut = "com.malexj.introduction.pointcut.AfterReturningPointcut.barkMethods()",
      returning = "bark")
  public void barkAfterReturningAdvice(Cat.Sound bark) {
    bark.setSound("No no no");
  }
}
