package gokhan.cihan.Library.business;

import gokhan.cihan.Library.dto.request.PublisherRequest;
import gokhan.cihan.Library.dto.response.PublisherResponse;

import java.util.List;

public interface IPublisherService {

    PublisherResponse getById(Long id);

    List<PublisherResponse> getAll();

    PublisherResponse create(PublisherRequest publisherRequest);

    PublisherResponse update(Long id, PublisherRequest publisherRequest);

    void delete(Long id);

}
