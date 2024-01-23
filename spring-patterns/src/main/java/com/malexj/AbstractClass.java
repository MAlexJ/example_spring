package com.malexj;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AbstractClass {
  protected void println(Object... obj) {
    String logs = Arrays.stream(obj).map(Object::toString).collect(Collectors.joining(" "));
    System.out.println(logs);
  }
}
