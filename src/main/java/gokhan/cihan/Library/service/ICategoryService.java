package gokhan.cihan.Library.service;

import gokhan.cihan.Library.dto.request.CategoryRequest;
import gokhan.cihan.Library.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {

    CategoryResponse getById(Long id);

    List<CategoryResponse> getAll();

    CategoryResponse create(CategoryRequest categoryRequest);

    CategoryResponse update(Long id, CategoryRequest categoryRequest);

    void delete(Long id);

}
