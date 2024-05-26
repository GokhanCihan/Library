package gokhan.cihan.Library.service;

import gokhan.cihan.Library.dto.request.BorrowingRequest;
import gokhan.cihan.Library.dto.response.BorrowingResponse;

import java.util.List;

public interface IBorrowingService {

    BorrowingResponse getById(Long id);

    List<BorrowingResponse> getAll();

    BorrowingResponse create(BorrowingRequest borrowingRequest);

    BorrowingResponse update(Long id, BorrowingRequest borrowingRequest);

    void delete(Long id);

}
