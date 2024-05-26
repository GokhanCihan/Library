package gokhan.cihan.Library.dto.mapper;

import gokhan.cihan.Library.dto.request.BorrowingRequest;
import gokhan.cihan.Library.dto.response.BorrowingResponse;
import gokhan.cihan.Library.entity.Borrowing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BorrowingMapper {

    BorrowingMapper MAPPER = Mappers.getMapper(BorrowingMapper.class);

    Borrowing asEntity(BorrowingRequest bookRequest);

    BorrowingResponse asOutput(Borrowing borrowing);

    List<BorrowingResponse> asOutput(List<Borrowing> borrowings);

    void update(@MappingTarget Borrowing borrowing, BorrowingRequest borrowingRequest);
}
