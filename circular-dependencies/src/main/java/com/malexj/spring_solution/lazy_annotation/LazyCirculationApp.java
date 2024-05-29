package com.malexj.spring_solution.lazy_annotation;

import com.malexj.base.AbstractClass;
import com.malexj.base.properties.PropsPropertySourcesConfiguration;
import com.malexj.spring_solution.lazy_annotation.bean.First;
import com.malexj.spring_solution.lazy_annotation.bean.LazyBeanInjection;
import org.junit.jupiter.api.Test;
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
    var ctx =
        new AnnotationConfigApplicationContext(
            First.class, LazyBeanInjection.class, PropsPropertySourcesConfiguration.class);
    var first = ctx.getBean(First.class);
    var second = ctx.getBean(LazyBeanInjection.class);

    println("first:", first);
    println("second:", second);
  }
}
