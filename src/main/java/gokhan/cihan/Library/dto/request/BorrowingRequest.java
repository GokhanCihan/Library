package gokhan.cihan.Library.dto.request;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class BorrowingRequest {
    private String borrower;
    private LocalDate dateBorrowed;
    private LocalDate dateReturned;
}
