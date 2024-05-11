package gokhan.cihan.Library.business;

import gokhan.cihan.Library.entity.Category;
import gokhan.cihan.Library.repository.CategoryRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getById(long id) {
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category data not found!"));
    }

    @Override
    public Page<Category> getAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepository.findAll(pageable);
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        this.getById(category.getId());
        return this.categoryRepository.save(category);
    }

    @Override
    public boolean delete(long id) {
        this.categoryRepository.delete(this.getById(id));
        return false;
    }
}
