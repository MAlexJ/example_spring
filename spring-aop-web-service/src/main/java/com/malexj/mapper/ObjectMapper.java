package com.malexj.mapper;

import com.malexj.entity.Book;
import com.malexj.model.request.BookRequest;
import com.malexj.model.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/** MapStruct mapper: */
@Mapper(componentModel = "spring")
public interface ObjectMapper {

  @Mapping(target = "id", ignore = true)
  Book requestToEntity(BookRequest request);

  BookResponse entityToResponse(Book entity);
}
