package kz.madik.midtermswdev.service;

import kz.madik.midtermswdev.dto.CategoryDto;
import kz.madik.midtermswdev.dto.CountryDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    void getAllTest() {
        List<CategoryDto> categoryDtos = categoryService.getAll();

        Assertions.assertNotNull(categoryDtos);

        Assertions.assertNotEquals(0, categoryDtos.size());

        for (CategoryDto dto : categoryDtos) {
            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getCategoryDto());
        }
    }

    @Test
    void getByIdTest() {

    }

    @Test
    void addTest() {

    }

    @Test
    void updateTest() {

    }

    @Test
    void deleteTest() {

    }
}
