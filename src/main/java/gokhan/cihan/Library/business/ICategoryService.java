package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {

    Category getById(long id);

    Page<Category> getAll(int page, int pageSize);

    Category save(Category category);

    Category update(Category category);

    boolean delete(long id);

}
