package kz.madik.midtermswdev.mapper;

import kz.madik.midtermswdev.dto.ItemDto;
import kz.madik.midtermswdev.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "descriptionDto", source = "description")
    @Mapping(target = "priceDto", source = "price")
    @Mapping(target = "categoryDto", source = "category")
    @Mapping(target = "countriesDto", source = "countries")
    ItemDto toDto(Item item);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "description", source = "descriptionDto")
    @Mapping(target = "price", source = "priceDto")
    @Mapping(target = "category", source = "categoryDto")
    @Mapping(target = "countries", source = "countriesDto")
    Item toEntity(ItemDto itemDto);

    List<ItemDto> toDtoList(List<Item> items);
}
