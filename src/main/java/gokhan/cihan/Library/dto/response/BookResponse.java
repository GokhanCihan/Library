package gokhan.cihan.Library.dto.response;

import gokhan.cihan.Library.entity.Author;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Year;

@Data
@RequiredArgsConstructor
public class BookResponse {
    private String title;
    private Integer yearPublished;
    private Integer stock;
}
