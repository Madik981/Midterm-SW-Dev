package kz.madik.midtermswdev.mapper;

import kz.madik.midtermswdev.dto.CountryDto;
import kz.madik.midtermswdev.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "codeDto", source = "code")
    @Mapping(target = "countryDto", source = "country")
    CountryDto toDto(Country country);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "code", source = "codeDto")
    @Mapping(target = "country", source = "countryDto")
    Country toEntity(CountryDto countryDto);

    List<CountryDto> toDtoList(List<Country> countries);
}
