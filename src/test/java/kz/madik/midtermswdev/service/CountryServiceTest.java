package kz.madik.midtermswdev.service;

import kz.madik.midtermswdev.dto.CountryDto;
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
public class CountryServiceTest {
    @Autowired
    private CountryService countryService;

    @Test
    void getAllTest() {
        List<CountryDto> countryDtos = countryService.getAll();

        Assertions.assertNotNull(countryDtos);

        Assertions.assertNotEquals(0, countryDtos.size());

        for (CountryDto dto : countryDtos) {
            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getCodeDto());
            Assertions.assertNotNull(dto.getCountryDto());
        }
    }

    @Test
    void getByIdTest() {
        Random random = new Random();
        int randomId = random.nextInt(countryService.getAll().size());
        Long someId = countryService.getAll().get(randomId).getIdDto();

        CountryDto countryDto = countryService.getById(someId);

        Assertions.assertNotNull(countryDto);

        Assertions.assertNotNull(countryDto.getIdDto());
        Assertions.assertNotNull(countryDto.getCodeDto());
        Assertions.assertNotNull(countryDto.getCountryDto());

        CountryDto check = countryService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        CountryDto countryDto = CountryDto
                .builder()
                .codeDto("KZ")
                .countryDto("Kazakhstan")
                .build();


        CountryDto add = countryService.addCountry(countryDto);

        Assertions.assertNotNull(add);

        Assertions.assertNotNull(add.getIdDto());
        Assertions.assertNotNull(add.getCodeDto());
        Assertions.assertNotNull(add.getCountryDto());

        Assertions.assertEquals(add.getCodeDto(), countryDto.getCodeDto());
        Assertions.assertEquals(add.getCountryDto(), countryDto.getCountryDto());


        CountryDto added = countryService.getById(add.getIdDto());

        Assertions.assertNotNull(added);

        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertNotNull(added.getCodeDto());
        Assertions.assertNotNull(added.getCountryDto());

        Assertions.assertEquals(added.getIdDto(), add.getIdDto());
        Assertions.assertEquals(added.getCodeDto(), add.getCodeDto());
        Assertions.assertEquals(added.getCountryDto(), add.getCountryDto());

    }

    @Test
    void updateTest() {
        Random random = new Random();
        int randomId = random.nextInt(countryService.getAll().size());
        Long someId = countryService.getAll().get(randomId).getIdDto();

        CountryDto updateItem = CountryDto
                .builder()
                .idDto(someId)
                .codeDto("KZ")
                .countryDto("Kazakhstan")
                .build();

        CountryDto update = countryService.updateById(updateItem.getIdDto(), updateItem);

        Assertions.assertNotNull(update);

        Assertions.assertNotNull(update.getIdDto());
        Assertions.assertNotNull(update.getCodeDto());
        Assertions.assertNotNull(update.getCountryDto());

        Assertions.assertEquals(update.getIdDto(), updateItem.getIdDto());
        Assertions.assertEquals(update.getCodeDto(), updateItem.getCodeDto());


        CountryDto updated = countryService.getById(update.getIdDto());

        Assertions.assertNotNull(updated);

        Assertions.assertNotNull(updated.getIdDto());
        Assertions.assertNotNull(updated.getCodeDto());
        Assertions.assertNotNull(updated.getCountryDto());

        Assertions.assertEquals(updated.getIdDto(), update.getIdDto());
        Assertions.assertEquals(updated.getCodeDto(), update.getCodeDto());
        Assertions.assertEquals(updated.getCountryDto(), update.getCountryDto());

    }

    @Test
    void deleteTest() {
        Random random = new Random();
        int randomId = random.nextInt(countryService.getAll().size());
        Long someId = countryService.getAll().get(randomId).getIdDto();

        Assertions.assertTrue(countryService.deleteById(someId));

        CountryDto deleted = countryService.getById(someId);

        Assertions.assertNull(deleted);
    }
}
