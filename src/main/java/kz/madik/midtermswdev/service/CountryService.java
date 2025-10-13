package kz.madik.midtermswdev.service;

import kz.madik.midtermswdev.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAll();
    CountryDto getById(Long id);
    void addCountry(CountryDto itemDto);
    CountryDto updateById(Long id, CountryDto itemDto);
    void deleteById(Long id);
}
