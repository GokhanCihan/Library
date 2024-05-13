package gokhan.cihan.Library.dto.mapper;

import gokhan.cihan.Library.dto.request.AuthorRequest;
import gokhan.cihan.Library.dto.response.AuthorResponse;
import gokhan.cihan.Library.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper MAPPER = Mappers.getMapper(AuthorMapper.class);

    Author asEntity(AuthorRequest authorRequest);

    AuthorResponse asOutput(Author author);

    List<AuthorResponse> asOutput(List<Author> authors);

    void update(@MappingTarget Author author, AuthorRequest authorRequest);

}
