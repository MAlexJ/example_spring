package com.malexj.training_course.postprocessor.bean;

import com.malexj.training_course.base.AbstractClass;
import com.malexj.training_course.postprocessor.annotation.Discount;
import lombok.Data;

@Data
public class Food extends AbstractClass {
  private String type;
  private String dishName;

  @Discount(percent = 30)
  private int percent;

  public Food(String type, String dishName) {
    this.type = type;
    this.dishName = dishName;
  }

  public int discount() {
    return percent;
  }
}
