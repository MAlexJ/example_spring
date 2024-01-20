package com.malexj.model.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BookRequest {
  private String title;

  private String author;
}
