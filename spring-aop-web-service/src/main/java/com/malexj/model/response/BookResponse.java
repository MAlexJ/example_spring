package com.malexj.model.response;

import lombok.Data;

@Data
public class BookResponse {
  public Long id;

  private String title;

  private String author;
}
