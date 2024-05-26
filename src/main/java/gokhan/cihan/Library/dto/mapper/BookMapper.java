package gokhan.cihan.Library.dto.mapper;

import gokhan.cihan.Library.dto.request.BookRequest;
import gokhan.cihan.Library.dto.response.BookResponse;
import gokhan.cihan.Library.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    Book asEntity(BookRequest bookRequest);

    BookResponse asOutput(Book book);

    List<BookResponse> asOutput(List<Book> books);

    void update(@MappingTarget Book book, BookRequest bookRequest);

}
