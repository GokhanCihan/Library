package gokhan.cihan.Library.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Year;

@Data
@RequiredArgsConstructor
public class PublisherRequest {
    private String name;
    private Integer yearEstablished;
}
