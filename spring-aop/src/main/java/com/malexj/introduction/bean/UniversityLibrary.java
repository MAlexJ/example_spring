package com.malexj.introduction.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary {

  @Value("${library.enable:true}")
  private boolean enable;

  public String getBook(String book) {
    return book;
  }

  public String returnBook(String book) {
    return book;
  }

  public String returnBookThrowingException(String book) {
    if (enable) {
      throw new RuntimeException();
    }
    return book;
  }
}
