package com.malexj.service;

import com.malexj.entity.Book;
import com.malexj.model.request.BookRequest;
import com.malexj.model.response.BookResponse;
import com.malexj.model.response.BooksResponse;
import com.malexj.repository.BookRepository;
import com.malexj.mapper.ObjectMapper;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository repository;

  private final ObjectMapper mapper;

  public BookResponse addNewBook(BookRequest request) {
    Book entity = mapper.requestToEntity(request);
    Book book = repository.save(entity);
    return mapper.entityToResponse(book);
  }

  public BooksResponse findAllBooks() {
    List<BookResponse> books = repository.findAll().stream().map(mapper::entityToResponse).toList();
    return new BooksResponse(books);
  }

  public BookResponse findBookByTitle(String title) {
    return repository.findBookByTitle(title).map(mapper::entityToResponse).orElseThrow();
  }
}
