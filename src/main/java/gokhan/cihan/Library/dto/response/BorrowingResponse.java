package gokhan.cihan.Library.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class BorrowingResponse {
    private String borrower;
    private LocalDate dateBorrowed;
    private LocalDate dateReturned;
}
