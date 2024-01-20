package com.malexj.service;

import com.malexj.entity.Book;
import com.malexj.mapper.ObjectMapper;
import com.malexj.model.request.BookRequest;
import com.malexj.model.response.BookListResponse;
import com.malexj.model.response.BookResponse;
import com.malexj.repository.BookRepository;
import java.util.List;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository repository;

  private final ObjectMapper mapper;

  public BookResponse addBook(BookRequest request) {
    return applyMapping(
        mapper.requestToEntity(request),
        book -> applyMapping(repository.save(book), mapper::entityToResponse));
  }

  public BookListResponse findBooks() {
    return applyMapping(repository.findAll(), BookListResponse::new);
  }

  public BookListResponse findBooksByTitle(String title) {
    return applyMapping(repository.findAllBooksByTitle(title), BookListResponse::new);
  }

  private BookResponse applyMapping(Book book, Function<Book, BookResponse> function) {
    return function.apply(book);
  }

  private BookListResponse applyMapping(
      List<Book> books, Function<List<BookResponse>, BookListResponse> function) {
    return function.apply(books.stream().map(mapper::entityToResponse).toList());
  }
}
