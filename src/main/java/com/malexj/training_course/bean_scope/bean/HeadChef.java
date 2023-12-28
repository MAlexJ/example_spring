package com.malexj.training_course.bean_scope.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class HeadChef {
  private String name;

  @Override
  public String toString() {
    return "HeadChef{ name='" + name + '}';
  }
}
