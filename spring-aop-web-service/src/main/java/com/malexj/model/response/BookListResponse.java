package com.malexj.model.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookListResponse {

  private List<BookResponse> books;
}
