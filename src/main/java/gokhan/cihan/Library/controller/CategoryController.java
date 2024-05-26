package gokhan.cihan.Library.controller;

import gokhan.cihan.Library.service.ICategoryService;
import gokhan.cihan.Library.dto.request.CategoryRequest;
import gokhan.cihan.Library.dto.response.CategoryResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/category")
@Tag(name = "Category Management")
public class CategoryController {
    public ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable("id") Long id){
        return categoryService.getById(id);
    }

    @GetMapping()
    public List<CategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @PostMapping()
    public CategoryResponse create(CategoryRequest categoryRequest) {
        return categoryService.create(categoryRequest);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable("id") Long id, CategoryRequest categoryRequest) {
        return categoryService.update(id, categoryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        categoryService.delete(id);
    }
}
