package com.malexj.spring_solution.lazy_annotation.bean;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Second {

  @Value("Second bean")
  private String name;

  private final First first;

  /**
   * Link to info: https://www.baeldung.com/circular-dependencies-in-spring#2-use-lazy
   *
   * <p>Description:
   *
   * <p>https://www.baeldung.com/circular-dependencies-in-spring#2-use-lazy
   */
  public Second(@Lazy First first) {
    this.first = first;
  }
}
