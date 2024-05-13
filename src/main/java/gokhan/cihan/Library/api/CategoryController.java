package gokhan.cihan.Library.api;

import gokhan.cihan.Library.business.ICategoryService;
import gokhan.cihan.Library.dto.request.CategoryRequest;
import gokhan.cihan.Library.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/category")
@RequiredArgsConstructor
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
