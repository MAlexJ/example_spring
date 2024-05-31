package com.malexj.training_course.naming_strategy.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cat")
public class Cat implements Animal {
  @Override
  public String name() {
    return "Stefan";
  }
}
