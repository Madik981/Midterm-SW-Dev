package kz.madik.midtermswdev.mapper;

import kz.madik.midtermswdev.dto.CategoryDto;
import kz.madik.midtermswdev.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "categoryDto", source = "category")
    CategoryDto toDto(Category category);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "category", source = "categoryDto")
    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtoList(List<Category> categories);
}
