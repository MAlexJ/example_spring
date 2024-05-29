package com.malexj.spring_solution.lazy_annotation.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Data
@Component
public class LazyBeanInjection {

  @Value("${second.bean.name:SecondBean}")
  private String name;

  private final First first;

  /**
   * Link to info: https://www.baeldung.com/circular-dependencies-in-spring#2-use-lazy
   *
   * <p>Description:
   *
   * <p>A simple way to break the cycle is by telling Spring to initialize one of the beans lazily.
   * So, instead of fully initializing the bean, it will create a proxy to inject it into the other
   * bean. The injected bean will only be fully created when it’s first needed.
   */
  public LazyBeanInjection(@Lazy First first) {
    this.first = first;
  }
}
