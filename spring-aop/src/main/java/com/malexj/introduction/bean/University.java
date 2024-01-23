package com.malexj.introduction.bean;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class University {

  public List<String> getStudents() {
    return List.of("Alex", "Anna", "Max");
  }

  public List<String> getStudentsWithException() {
    if (true) {
      throw new RuntimeException();
    }
    return List.of("Alex", "Anna", "Max");
  }
}
