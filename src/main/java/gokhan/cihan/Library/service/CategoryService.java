package gokhan.cihan.Library.service;

import gokhan.cihan.Library.dto.mapper.CategoryMapper;
import gokhan.cihan.Library.dto.request.CategoryRequest;
import gokhan.cihan.Library.dto.response.CategoryResponse;
import gokhan.cihan.Library.entity.Category;
import gokhan.cihan.Library.repository.CategoryRepository;
import gokhan.cihan.Library.utilitiy.exceptionHandler.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse getById(Long id) {
        return CategoryMapper.MAPPER.asOutput(categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category data by id = " + id + " not found!")));
    }

    @Override
    public List<CategoryResponse> getAll() {
        return CategoryMapper.MAPPER.asOutput(categoryRepository.findAll());
    }

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        Optional<Category> searchedCategory = categoryRepository.findByName(categoryRequest.getName());
        if (searchedCategory.isEmpty()) {
            Category savedCategory = categoryRepository.save(CategoryMapper.MAPPER.asEntity(categoryRequest));
            return CategoryMapper.MAPPER.asOutput(savedCategory);
        }
        throw new NotFoundException("This category already exists!");
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest categoryRequest) {
        Optional<Category> categoryFromDB = categoryRepository.findById(id);
        if (categoryFromDB.isEmpty()) {
            throw new NotFoundException("Category not found!");
        }
        Category category = categoryFromDB.get();
        CategoryMapper.MAPPER.update(category, categoryRequest);
        return CategoryMapper.MAPPER.asOutput(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()){
            categoryRepository.delete(category.get());
        }else {
            throw new NotFoundException("Category data not found");
        }
    }

}
