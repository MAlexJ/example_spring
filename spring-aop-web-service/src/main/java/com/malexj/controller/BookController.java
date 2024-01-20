package com.malexj.controller;

import com.malexj.model.request.BookRequest;
import com.malexj.model.response.BookResponse;
import com.malexj.model.response.BooksResponse;
import com.malexj.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService service;

  @PostMapping(
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BookResponse> addNewBook(@RequestBody BookRequest request) {
    var response = service.addNewBook(request);
    return ResponseEntity.ok(response);
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BooksResponse> findAllBooks() {
    var responses = service.findAllBooks();
    return ResponseEntity.ok(responses);
  }

  @GetMapping(name = "/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BookResponse> findBookByTitle(@PathVariable String title) {
    var response = service.findBookByTitle(title);
    return ResponseEntity.ok(response);
  }
}
