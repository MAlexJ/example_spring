package com.malexj.training_course.postprocessor.bean;

import com.malexj.training_course.base.AbstractClass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("waiter")
public class Waiter extends AbstractClass {

  private static final String WAITER_ON_DUTY = "I can take order";
  private static final String WAITER_NOT_ON_DUTY = "I'm not on duty";

  private boolean onDuty;

  public String takeOrder() {
    if (onDuty) {
      println("I can take order");
      return WAITER_ON_DUTY;
    }

    println("I'm not on duty");
    return WAITER_NOT_ON_DUTY;
  }
}
