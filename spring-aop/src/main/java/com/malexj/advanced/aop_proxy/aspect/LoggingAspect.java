package com.malexj.advanced.aop_proxy.aspect;

import com.malexj.advanced.aop_proxy.bean.Student;
import com.malexj.base.AbstractClass;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect extends AbstractClass {

  @Pointcut("execution(* com.malexj.advanced.aop_proxy.bean.Student.getAge(..))")
  public void studentGetMethod() {}

  @SneakyThrows
  @Around("studentGetMethod()")
  public Object studentBeforeAdvice(ProceedingJoinPoint joinPoint) {
    if (joinPoint.getTarget() instanceof Student student) {
      int age = 20;
      println("Going to setup student profile with age:", age);
      student.setAge(age);
    }
    return joinPoint.proceed();
  }
}
