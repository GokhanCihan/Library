package gokhan.cihan.Library.dto.mapper;

import gokhan.cihan.Library.dto.request.CategoryRequest;
import gokhan.cihan.Library.dto.response.CategoryResponse;
import gokhan.cihan.Library.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);

    Category asEntity(CategoryRequest categoryRequest);

    CategoryResponse asOutput(Category category);

    List<CategoryResponse> asOutput(List<Category> categories);

    void update(@MappingTarget Category category, CategoryRequest categoryRequest);

}
