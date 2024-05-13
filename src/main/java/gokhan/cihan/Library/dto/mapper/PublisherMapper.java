package gokhan.cihan.Library.dto.mapper;

import gokhan.cihan.Library.dto.request.PublisherRequest;
import gokhan.cihan.Library.dto.response.PublisherResponse;
import gokhan.cihan.Library.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublisherMapper {
    PublisherMapper MAPPER = Mappers.getMapper(PublisherMapper.class);

    Publisher asEntity(PublisherRequest publisherRequest);

    PublisherResponse asOutput(Publisher publisher);

    List<PublisherResponse> asOutput(List<Publisher> publishers);

    void update(@MappingTarget Publisher category, PublisherRequest publisherRequest);
}
