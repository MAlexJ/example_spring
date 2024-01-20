package com.malexj.aop;

import com.malexj.service.BookService;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Aspects {

  private static final List<String> methods;

  static {
    methods = Arrays.stream(BookService.class.getDeclaredMethods()).map(Method::getName).toList();
  }

  @SneakyThrows
  @Around("Pointcuts.allFindMethods()")
  public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
    String name = joinPoint.getSignature().getName();
    if (methods.contains(name)) {
      Arrays.stream(joinPoint.getArgs())
          .forEach(title -> log.info("BookService, method - {}, title - {}", name, title));
    }
    return joinPoint.proceed();
  }
}
