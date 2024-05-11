package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Publisher;
import gokhan.cihan.Library.repository.PublisherRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PublisherService implements IPublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher getById(long id) {
        return this.publisherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Publisher data not found!"));
    }

    @Override
    public Page<Publisher> getAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.publisherRepository.findAll(pageable);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        this.getById(publisher.getId());
        return this.publisherRepository.save(publisher);
    }

    @Override
    public boolean delete(long id) {
        this.publisherRepository.delete(this.getById(id));
        return false;
    }
}
