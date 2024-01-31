package com.malexj.spring_solution.lazy_annotation;

import com.malexj.base.AbstractClass;
import com.malexj.spring_solution.lazy_annotation.bean.First;
import com.malexj.spring_solution.lazy_annotation.bean.Second;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyCirculationApp extends AbstractClass {

  @Test
  public void runApp() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(First.class, Second.class);
    var first = ctx.getBean(First.class);
    var second = ctx.getBean(Second.class);
  }
}
