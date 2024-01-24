package com.malexj.introduction.bean;

import com.malexj.base.AbstractClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class Student extends AbstractClass {

  private String firstName;
  private String secondName;

  public void printThrowException() {
    println("1. Exception raised");
    throw new IllegalArgumentException("2. throw exception");
  }
}
