package com.malexj.training_course.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UtilsClass {

  public static void println(Object... obj) {
    String logs = Arrays.stream(obj).map(Object::toString).collect(Collectors.joining(" "));
    System.out.println(logs);
  }
}
