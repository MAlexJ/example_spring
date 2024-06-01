package com.malexj.training_course.base;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AbstractClass {

  protected void println(Object... obj) {
    if (Objects.isNull(obj)) {
      return;
    }
    String logs =
        Arrays.stream(obj)
            .filter(Objects::nonNull)
            .map(Object::toString)
            .collect(Collectors.joining(" "));
    print(logs);
  }

  protected void println(String... srt) {
    if (Objects.isNull(srt)) {
      return;
    }
    String logs = Arrays.stream(srt).filter(Objects::nonNull).collect(Collectors.joining(" "));
    print(logs);
  }

  protected void printWewLine(String... srt) {
    if (Objects.isNull(srt)) {
      return;
    }
    String logs = Arrays.stream(srt).filter(Objects::nonNull).collect(Collectors.joining("\n"));
    print(logs);
  }

  private void print(String str) {
    System.out.println(str);
  }
}
