package gokhan.cihan.Library.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Year;

@Data
@RequiredArgsConstructor
public class AuthorResponse {
    private String name;
    private Integer yearOfBirth;
    private String country;
}
