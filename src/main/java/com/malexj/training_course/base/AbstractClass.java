package com.malexj.training_course.base;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class AbstractClass {

  protected void println(Object... obj) {
    String logs = Arrays.stream(obj).map(Object::toString).collect(Collectors.joining(" "));
    print(logs);
  }

  private void print(String str) {
    System.out.println(str);
  }
}
