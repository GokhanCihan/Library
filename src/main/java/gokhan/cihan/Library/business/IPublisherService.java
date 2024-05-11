package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Publisher;

import java.util.List;

public interface IPublisherService {

    Publisher getById(long id);

    List<Publisher> getAll(int page, int pageSize);

    Publisher save(Publisher publisher);

    Publisher update(Publisher publisher);

    boolean delete(long id);

}
