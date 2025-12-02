package kz.madik.midtermswdev.service;

import kz.madik.midtermswdev.dto.CategoryDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

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
        Random random = new Random();
        int randomId = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(randomId).getIdDto();

        CategoryDto categoryDto = categoryService.getById(someId);

        Assertions.assertNotNull(categoryDto);

        Assertions.assertNotNull(categoryDto.getIdDto());
        Assertions.assertNotNull(categoryDto.getCategoryDto());

        CategoryDto check = categoryService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        CategoryDto categoryDto = CategoryDto
                .builder()
                .categoryDto("test")
                .build();


        CategoryDto add = categoryService.addCategory(categoryDto);

        Assertions.assertNotNull(add);

        Assertions.assertNotNull(add.getIdDto());
        Assertions.assertNotNull(add.getCategoryDto());

        Assertions.assertEquals(add.getIdDto(), categoryDto.getIdDto());
        Assertions.assertEquals(add.getCategoryDto(), categoryDto.getCategoryDto());


        CategoryDto added = categoryService.getById(add.getIdDto());

        Assertions.assertNotNull(added);

        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertNotNull(added.getCategoryDto());

        Assertions.assertEquals(added.getIdDto(), add.getIdDto());
        Assertions.assertEquals(added.getCategoryDto(), add.getCategoryDto());

    }

    @Test
    void updateTest() {
        Random random = new Random();
        int randomId = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(randomId).getIdDto();

        CategoryDto updateItem = CategoryDto
                .builder()
                .idDto(someId)
                .categoryDto("test")
                .build();

        CategoryDto update = categoryService.updateById(updateItem.getIdDto(), updateItem);

        Assertions.assertNotNull(update);

        Assertions.assertNotNull(update.getIdDto());
        Assertions.assertNotNull(update.getCategoryDto());

        Assertions.assertEquals(update.getIdDto(), updateItem.getIdDto());
        Assertions.assertEquals(update.getCategoryDto(), updateItem.getCategoryDto());


        CategoryDto updated = categoryService.getById(update.getIdDto());

        Assertions.assertNotNull(updated);

        Assertions.assertNotNull(updated.getIdDto());
        Assertions.assertNotNull(updated.getCategoryDto());

        Assertions.assertEquals(updated.getIdDto(), update.getIdDto());
        Assertions.assertEquals(updated.getCategoryDto(), update.getCategoryDto());

    }

    @Test
    void deleteTest() {
        Random random = new Random();
        int randomId = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(randomId).getIdDto();

        Assertions.assertTrue(categoryService.deleteById(someId));

        CategoryDto deleted = categoryService.getById(someId);

        Assertions.assertNull(deleted);
    }
}
