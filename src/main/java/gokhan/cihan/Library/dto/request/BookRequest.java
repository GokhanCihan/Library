package gokhan.cihan.Library.dto.request;

import gokhan.cihan.Library.entity.Author;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Year;

@Data
@RequiredArgsConstructor
public class BookRequest {
    private String title;
    private Integer yearPublished;
    private Integer stock;
}
