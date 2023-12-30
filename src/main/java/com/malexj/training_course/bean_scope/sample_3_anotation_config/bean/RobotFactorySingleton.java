package com.malexj.training_course.bean_scope.sample_3_anotation_config.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RobotFactorySingleton {

  // field injection!
  public RobotPrototype createRobot() {
    return new RobotPrototype();
  }
}
