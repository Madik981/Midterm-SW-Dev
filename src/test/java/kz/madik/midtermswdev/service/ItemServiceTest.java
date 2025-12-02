package kz.madik.midtermswdev.service;

import kz.madik.midtermswdev.dto.ItemDto;
import kz.madik.midtermswdev.entity.Category;
import kz.madik.midtermswdev.entity.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;

    @Test
    void getAllTest() {
        List<ItemDto> itemDtos = itemService.getAll();

        Assertions.assertNotNull(itemDtos);

        Assertions.assertNotEquals(0, itemDtos.size());

        for (ItemDto dto : itemDtos) {
            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getDescriptionDto());
            Assertions.assertNotNull(dto.getPriceDto());
            Assertions.assertNotNull(dto.getCategoryDto());
            Assertions.assertNotNull(dto.getCountriesDto());
        }
    }

    @Test
    void getByIdTest() {
        Random random = new Random();
        int randomId = random.nextInt(itemService.getAll().size());
        Long someId = itemService.getAll().get(randomId).getIdDto();

        ItemDto itemDto = itemService.getById(someId);

        Assertions.assertNotNull(itemDto);

        Assertions.assertNotNull(itemDto.getIdDto());
        Assertions.assertNotNull(itemDto.getNameDto());
        Assertions.assertNotNull(itemDto.getDescriptionDto());
        Assertions.assertNotNull(itemDto.getPriceDto());
        Assertions.assertNotNull(itemDto.getCategoryDto());
        Assertions.assertNotNull(itemDto.getCountriesDto());

        ItemDto check = itemService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        ItemDto itemDto = ItemDto
                .builder()
                .nameDto("iPhone 15 Pro")
                .descriptionDto("Flagship smartphone")
                .priceDto(1000)
                .categoryDto(
                        Category
                                .builder()
                                .id(1L)
                                .build()
                )
                .countriesDto(
                        List.of(
                                Country
                                        .builder()
                                        .id(1L)
                                        .build(),
                                Country
                                        .builder()
                                        .id(2L)
                                        .build()
                        )
                )
                .build();


        ItemDto add = itemService.addItem(itemDto);

        Assertions.assertNotNull(add);

        Assertions.assertNotNull(add.getIdDto());
        Assertions.assertNotNull(add.getNameDto());
        Assertions.assertNotNull(add.getDescriptionDto());
        Assertions.assertNotNull(add.getPriceDto());
        Assertions.assertNotNull(add.getCategoryDto());
        Assertions.assertNotNull(add.getCountriesDto());

        Assertions.assertEquals(add.getNameDto(), itemDto.getNameDto());
        Assertions.assertEquals(add.getDescriptionDto(), itemDto.getDescriptionDto());
        Assertions.assertEquals(add.getPriceDto(), itemDto.getPriceDto());
        Assertions.assertEquals(add.getCategoryDto(), itemDto.getCategoryDto());
        Assertions.assertEquals(add.getCountriesDto(), itemDto.getCountriesDto());


        ItemDto added = itemService.getById(add.getIdDto());

        Assertions.assertNotNull(added);

        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertNotNull(added.getNameDto());
        Assertions.assertNotNull(added.getDescriptionDto());
        Assertions.assertNotNull(added.getPriceDto());
        Assertions.assertNotNull(added.getCategoryDto());
        Assertions.assertNotNull(added.getCountriesDto());

        Assertions.assertEquals(added.getIdDto(), add.getIdDto());
        Assertions.assertEquals(added.getNameDto(), add.getNameDto());
        Assertions.assertEquals(added.getDescriptionDto(), add.getDescriptionDto());
        Assertions.assertEquals(added.getPriceDto(), add.getPriceDto());
        Assertions.assertEquals(added.getCategoryDto().getId(), add.getCategoryDto().getId());
        Assertions.assertEquals(added.getCountriesDto().size(), add.getCountriesDto().size());

        List<Country> addedCountries = added.getCountriesDto();
        List<Country> addCountries = add.getCountriesDto();
        for(int i = 0; i < addedCountries.size(); i++) {
            Assertions.assertEquals(addedCountries.get(i).getId(), addCountries.get(i).getId());
        }
    }

    @Test
    void updateTest() {
        Random random = new Random();
        int randomId = random.nextInt(itemService.getAll().size());
        Long someId = itemService.getAll().get(randomId).getIdDto();

        ItemDto updateItem = ItemDto
                .builder()
                .idDto(someId)
                .nameDto("Updated Name")
                .descriptionDto("Updated Description")
                .priceDto(2000)
                .categoryDto(
                        Category
                                .builder()
                                .id(2L)
                                .build()
                )
                .countriesDto(
                        List.of(
                                Country
                                        .builder()
                                        .id(2L)
                                        .build()
                        )
                )
                .build();

        ItemDto update = itemService.updateById(updateItem.getIdDto(), updateItem);

        Assertions.assertNotNull(update);

        Assertions.assertNotNull(update.getIdDto());
        Assertions.assertNotNull(update.getNameDto());
        Assertions.assertNotNull(update.getDescriptionDto());
        Assertions.assertNotNull(update.getPriceDto());
        Assertions.assertNotNull(update.getCategoryDto());
        Assertions.assertNotNull(update.getCountriesDto());

        Assertions.assertEquals(update.getIdDto(), updateItem.getIdDto());
        Assertions.assertEquals(update.getNameDto(), updateItem.getNameDto());
        Assertions.assertEquals(update.getDescriptionDto(), updateItem.getDescriptionDto());
        Assertions.assertEquals(update.getPriceDto(), updateItem.getPriceDto());
        Assertions.assertEquals(update.getCategoryDto().getId(), updateItem.getCategoryDto().getId());
        Assertions.assertEquals(update.getCountriesDto().size(), updateItem.getCountriesDto().size());

        List<Country> updateCountries = update.getCountriesDto();
        List<Country> updateItemCountries = updateItem.getCountriesDto();
        for(int i = 0; i < updateCountries.size(); i++) {
            Assertions.assertEquals(updateCountries.get(i).getId(), updateItemCountries.get(i).getId());
        }


        ItemDto updated = itemService.getById(update.getIdDto());

        Assertions.assertNotNull(updated);

        Assertions.assertNotNull(updated.getIdDto());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getDescriptionDto());
        Assertions.assertNotNull(updated.getPriceDto());
        Assertions.assertNotNull(updated.getCategoryDto());
        Assertions.assertNotNull(updated.getCountriesDto());

        Assertions.assertEquals(updated.getIdDto(), update.getIdDto());
        Assertions.assertEquals(updated.getNameDto(), update.getNameDto());
        Assertions.assertEquals(updated.getDescriptionDto(), update.getDescriptionDto());
        Assertions.assertEquals(updated.getPriceDto(), update.getPriceDto());
        Assertions.assertEquals(updated.getCategoryDto().getId(), update.getCategoryDto().getId());
        Assertions.assertEquals(updated.getCountriesDto().size(), update.getCountriesDto().size());

        List<Country> updatedCountries = updated.getCountriesDto();
        for(int i = 0; i < updatedCountries.size(); i++) {
            Assertions.assertEquals(updatedCountries.get(i).getId(), updateCountries.get(i).getId());
        }
    }

    @Test
    void deleteTest() {
        Random random = new Random();
        int randomId = random.nextInt(itemService.getAll().size());
        Long someId = itemService.getAll().get(randomId).getIdDto();

        Assertions.assertTrue(itemService.deleteById(someId));

        ItemDto deleted = itemService.getById(someId);

        Assertions.assertNull(deleted);
    }
}
