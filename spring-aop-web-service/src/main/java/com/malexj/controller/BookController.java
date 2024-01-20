package com.malexj.controller;

import com.malexj.model.request.BookRequest;
import com.malexj.model.response.BookListResponse;
import com.malexj.model.response.BookResponse;
import com.malexj.service.BookService;
import java.util.Optional;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BookController {

  private final BookService service;
  private final Predicate<BookListResponse> bookTitlePredicate = r -> !r.getBooks().isEmpty();

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BookResponse> addNewBook(@RequestBody BookRequest request) {
    return ResponseEntity.ok(service.addBook(request));
  }

  @GetMapping()
  public ResponseEntity<BookListResponse> findBooks(
      @RequestParam(name = "title", required = false) String title) {
    return Optional.ofNullable(title)
        .map(
            titleVal ->
                Optional.of(service.findBooksByTitle(titleVal))
                    .filter(bookTitlePredicate)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build()))
        .orElse(ResponseEntity.ok(service.findBooks()));
  }
}
