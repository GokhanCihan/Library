package gokhan.cihan.Library.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Year;

@Data
@RequiredArgsConstructor
public class AuthorRequest {
    private String name;
    private String country;
    private Integer yearOfBirth;
}
