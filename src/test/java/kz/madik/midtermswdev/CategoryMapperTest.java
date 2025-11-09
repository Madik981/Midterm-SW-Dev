package kz.madik.midtermswdev;

import kz.madik.midtermswdev.dto.CategoryDto;
import kz.madik.midtermswdev.entity.Category;
import kz.madik.midtermswdev.mapper.CategoryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void convertEntityToDtoTest() {
        Category category = new Category(1L, "Phone");

        CategoryDto categoryDto = categoryMapper.toDto(category);

        Assertions.assertNotNull(categoryDto);

        Assertions.assertNotNull(categoryDto.getIdDto());
        Assertions.assertNotNull(categoryDto.getCategoryDto());

        Assertions.assertEquals(category.getId(), categoryDto.getIdDto());
        Assertions.assertEquals(category.getCategory(), categoryDto.getCategoryDto());

    }

    @Test
    void convertDtoToEntityTest() {
        CategoryDto categoryDto = new CategoryDto(1L, "Phone");

        Category category = categoryMapper.toEntity(categoryDto);

        Assertions.assertNotNull(category);

        Assertions.assertNotNull(category.getId());
        Assertions.assertNotNull(category.getCategory());

        Assertions.assertEquals(categoryDto.getIdDto(), category.getId());
        Assertions.assertEquals(categoryDto.getCategoryDto(), category.getCategory());

    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Phone"));
        categories.add(new Category(2L, "Laptop"));
        categories.add(new Category(3L, "Headphones"));

        List<CategoryDto> categoriesDto = categoryMapper.toDtoList(categories);

        Assertions.assertNotNull(categoriesDto);

        Assertions.assertNotEquals(0, categoriesDto.size());

        Assertions.assertEquals(categories.size(), categoriesDto.size());

        for(int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);

            CategoryDto categoryDto = categoriesDto.get(i);

            Assertions.assertNotNull(categoryDto);

            Assertions.assertNotNull(categoryDto.getIdDto());
            Assertions.assertNotNull(categoryDto.getCategoryDto());

            Assertions.assertEquals(category.getId(), categoryDto.getIdDto());
            Assertions.assertEquals(category.getCategory(), categoryDto.getCategoryDto());

        }
    }
}
