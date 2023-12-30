package com.malexj.training_course.bean_scope.sample_1.bean;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Waiter {

  private String name;
}
