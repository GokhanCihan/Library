package gokhan.cihan.Library.controller;

import gokhan.cihan.Library.service.IPublisherService;
import gokhan.cihan.Library.dto.request.PublisherRequest;
import gokhan.cihan.Library.dto.response.PublisherResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/publisher")
@Tag(name = "Publisher Management")
public class PublisherController {
    private final IPublisherService publisherService;

    public PublisherController(IPublisherService publisherService) {
        this.publisherService = publisherService;
    }

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
