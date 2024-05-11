package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Publisher;
import org.springframework.data.domain.Page;

public interface IPublisherService {

    Publisher getById(long id);

    Page<Publisher> getAll(int page, int pageSize);

    Publisher save(Publisher publisher);

    Publisher update(Publisher publisher);

    boolean delete(long id);

}
