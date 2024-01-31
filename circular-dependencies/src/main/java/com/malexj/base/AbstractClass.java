package com.malexj.base;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbstractClass {
  protected void println(Object... obj) {
    String logs =
        Arrays.stream(obj)
            .filter(Objects::nonNull)
            .map(Object::toString)
            .collect(Collectors.joining(" "));
    System.out.println(logs);
  }
}
