package gokhan.cihan.Library.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryRequest {
    private String name;
    private String description;
}
