package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Category;

import java.util.List;

public interface ICategoryService {

    Category getById(long id);

    List<Category> getAll(int page, int pageSize);

    Category save(Category category);

    Category update(Category category);

    boolean delete(long id);

}
