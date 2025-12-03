package kz.madik.midtermswdev.service.impl;

import kz.madik.midtermswdev.dto.CountryDto;
import kz.madik.midtermswdev.entity.Country;
import kz.madik.midtermswdev.mapper.CountryMapper;
import kz.madik.midtermswdev.repository.CountryRepository;
import kz.madik.midtermswdev.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryDto> getAll() {
        return countryMapper.toDtoList(countryRepository.findAll());
    }

    @Override
    public CountryDto getById(Long id) {
        return countryMapper.toDto(countryRepository.findById(id).orElse(null));
    }

    @Override
    public CountryDto addCountry(CountryDto countryDto) {
        return countryMapper.toDto(countryRepository.save(countryMapper.toEntity(countryDto)));
    }

    @Override
    public CountryDto updateById(Long id, CountryDto countryDto) {
        Country country = countryMapper.toEntity(countryDto);

        Country updateCountry = countryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));

        updateCountry.setCode(country.getCode());
        updateCountry.setCountry(country.getCountry());

        return countryMapper.toDto(countryRepository.save(updateCountry));
    }

    @Override
    public boolean deleteById(Long id) {
        countryRepository.deleteById(id);

        Country country = countryRepository.findById(id).orElse(null);

        return country == null;
    }
}
