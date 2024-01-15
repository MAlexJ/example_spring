package com.malexj.training_course.postprocessor.bean;

import lombok.Data;

@Data
public class Food {
  private String type;
  private String dishName;

  public Food(String type, String dishName) {
    this.type = type;
    this.dishName = dishName;
  }
}
