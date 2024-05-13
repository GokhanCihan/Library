package gokhan.cihan.Library.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryResponse {
    private String name;
    private String description;
}
