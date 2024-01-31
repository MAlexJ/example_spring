package com.malexj.spring_solution.lazy_annotation;

import com.malexj.base.AbstractClass;
import com.malexj.spring_solution.lazy_annotation.bean.First;
import com.malexj.spring_solution.lazy_annotation.bean.Second;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Link: https://www.baeldung.com/circular-dependencies-in-spring#2-use-lazy
 *
 * <p>A simple way to break the cycle is by telling Spring to initialize one of the beans lazily.
 * So, instead of fully initializing the bean, it will create a proxy to inject it into the other
 * bean. The injected bean will only be fully created when it’s first needed.
 */
public class LazyCirculationApp extends AbstractClass {

  @Test
  public void runApp() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(First.class, Second.class);
    var first = ctx.getBean(First.class);
    var second = ctx.getBean(Second.class);

    println("first:", first);
    println("second:", second);
  }
}
