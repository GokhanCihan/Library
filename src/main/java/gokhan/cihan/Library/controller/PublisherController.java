package gokhan.cihan.Library.controller;

import gokhan.cihan.Library.service.IPublisherService;
import gokhan.cihan.Library.dto.request.PublisherRequest;
import gokhan.cihan.Library.dto.response.PublisherResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/publisher")
public class PublisherController {
    private IPublisherService publisherService;

    @GetMapping("/{id}")
    public PublisherResponse getById(@PathVariable("id") Long id){
        return publisherService.getById(id);
    }

    @GetMapping()
    public List<PublisherResponse> getAll() {
        return publisherService.getAll();
    }

    @PostMapping()
    public PublisherResponse create(PublisherRequest publisherRequest) {
        return publisherService.create(publisherRequest);
    }

    @PutMapping("/{id}")
    public PublisherResponse update(@PathVariable("id") Long id, PublisherRequest publisherRequest) {
        return publisherService.update(id, publisherRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        publisherService.delete(id);
    }
}
