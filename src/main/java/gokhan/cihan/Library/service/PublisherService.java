package gokhan.cihan.Library.service;

import gokhan.cihan.Library.dto.mapper.PublisherMapper;
import gokhan.cihan.Library.dto.request.PublisherRequest;
import gokhan.cihan.Library.dto.response.PublisherResponse;
import gokhan.cihan.Library.entity.Publisher;
import gokhan.cihan.Library.repository.PublisherRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService implements IPublisherService {
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public PublisherResponse getById(Long id) {
        return PublisherMapper.MAPPER.asOutput(publisherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Publisher data by id = " + id + " not found!")));
    }

    @Override
    public List<PublisherResponse> getAll() {
        return PublisherMapper.MAPPER.asOutput(publisherRepository.findAll());
    }

    @Override
    public PublisherResponse create(PublisherRequest publisherRequest) {
        Optional<Publisher> searchedPublisher = publisherRepository.findByName(publisherRequest.getName());
        if (searchedPublisher.isEmpty()){
            Publisher savedPublisher = publisherRepository.save(PublisherMapper.MAPPER.asEntity(publisherRequest));
            return PublisherMapper.MAPPER.asOutput(savedPublisher);
        }
        throw new NotFoundException("This publisher already exists!");
    }

    @Override
    public PublisherResponse update(Long id, PublisherRequest publisherRequest) {
        Optional<Publisher> categoryFromDb = publisherRepository.findById(id);
        if(categoryFromDb.isEmpty()) {
            throw new NotFoundException("Publisher not found!");
        }
        Publisher publisher = categoryFromDb.get();
        PublisherMapper.MAPPER.update(publisher, publisherRequest);
        return PublisherMapper.MAPPER.asOutput(publisherRepository.save(publisher));
    }

    @Override
    public void delete(Long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        if (publisher.isPresent()){
            publisherRepository.delete(publisher.get());
        }else {
            throw new NotFoundException("Publisher data not found");
        }
    }
}
