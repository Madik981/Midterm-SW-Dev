package kz.madik.midtermswdev.mapper;

import kz.madik.midtermswdev.dto.CountryDto;
import kz.madik.midtermswdev.entity.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CountryMapperTest {
    @Autowired
    private CountryMapper countryMapper;

    @Test
    void convertEntityToDtoTest() {
        Country country = new Country(1L, "KZ", "Kazakhstan");
        var countryDto = countryMapper.toDto(country);

        Assertions.assertNotNull(countryDto);

        Assertions.assertNotNull(countryDto.getIdDto());
        Assertions.assertNotNull(countryDto.getCodeDto());
        Assertions.assertNotNull(countryDto.getCountryDto());

        Assertions.assertEquals(country.getId(), countryDto.getIdDto());
        Assertions.assertEquals(country.getCode(), countryDto.getCodeDto());
        Assertions.assertEquals(country.getCountry(), countryDto.getCountryDto());

    }

    @Test
    void convertDtoToEntityTest() {
        CountryDto countryDto = new CountryDto(1L, "KZ", "Kazakhstan");
        Country country = countryMapper.toEntity(countryDto);

        Assertions.assertNotNull(country);

        Assertions.assertNotNull(country.getId());
        Assertions.assertNotNull(country.getCode());
        Assertions.assertNotNull(country.getCountry());

        Assertions.assertEquals(countryDto.getIdDto(), country.getId());
        Assertions.assertEquals(countryDto.getCodeDto(), country.getCode());
        Assertions.assertEquals(countryDto.getCountryDto(), country.getCountry());

    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country(1L, "KZ", "Kazakhstan"));
        countries.add(new Country(2L, "US", "United States"));
        countries.add(new Country(3L, "FR", "France"));

        List<CountryDto> countriesDto = countryMapper.toDtoList(countries);

        Assertions.assertNotNull(countriesDto);

        Assertions.assertNotEquals(0, countriesDto.size());

        Assertions.assertEquals(countries.size(), countriesDto.size());

        for(int i = 0; i < countries.size(); i++) {
            Country country = countries.get(i);

            CountryDto countryDto = countriesDto.get(i);

            Assertions.assertNotNull(countryDto);

            Assertions.assertNotNull(countryDto.getIdDto());
            Assertions.assertNotNull(countryDto.getCodeDto());
            Assertions.assertNotNull(countryDto.getCountryDto());

            Assertions.assertEquals(country.getId(), countryDto.getIdDto());
            Assertions.assertEquals(country.getCode(), countryDto.getCodeDto());
            Assertions.assertEquals(country.getCountry(), countryDto.getCountryDto());

        }
    }
}
