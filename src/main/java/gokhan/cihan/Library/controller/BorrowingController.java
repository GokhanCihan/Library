package gokhan.cihan.Library.controller;

import gokhan.cihan.Library.service.IBorrowingService;
import gokhan.cihan.Library.dto.request.BorrowingRequest;
import gokhan.cihan.Library.dto.response.BorrowingResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/borrowing")
public class BorrowingController {
    private final IBorrowingService borrowingService;

    public BorrowingController(IBorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("/{id}")
    public BorrowingResponse getById(@PathVariable("id") Long id) {
        return borrowingService.getById(id);
    }

    @GetMapping()
    public List<BorrowingResponse> getAll() {
        return borrowingService.getAll();
    }

    @PostMapping()
    public BorrowingResponse create(BorrowingRequest borrowingRequest) {
        return borrowingService.create(borrowingRequest);
    }

    @PutMapping("/{id}")
    public BorrowingResponse update(@PathVariable("id") Long id, BorrowingRequest borrowingRequest) {
        return borrowingService.update(id, borrowingRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        borrowingService.delete(id);
    }
}
