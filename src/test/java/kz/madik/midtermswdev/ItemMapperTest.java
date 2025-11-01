package kz.madik.midtermswdev;

import kz.madik.midtermswdev.entity.Category;
import kz.madik.midtermswdev.entity.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import kz.madik.midtermswdev.dto.ItemDto;
import kz.madik.midtermswdev.entity.Item;
import kz.madik.midtermswdev.mapper.ItemMapper;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    void convertEntityToDtoTest(){

        Item itemEntity = new Item(1L, "iPhone 15 Pro", "Powerful Smartphone", 1000, new Category(1L, "Smartphone"), List.of(new Country(1L, "KZ", "Kazakhstan")));

        ItemDto itemDto = itemMapper.toDto(itemEntity);

        Assertions.assertNotNull(itemDto);

        Assertions.assertNotNull(itemDto.getNameDto());
        Assertions.assertNotNull(itemDto.getDescriptionDto());
        Assertions.assertNotNull(itemDto.getPriceDto());
        Assertions.assertNotNull(itemDto.getCategoryDto());
        Assertions.assertNotNull(itemDto.getCountriesDto());

        Assertions.assertEquals(itemEntity.getName(), itemDto.getNameDto());
        Assertions.assertEquals(itemEntity.getDescription(), itemDto.getDescriptionDto());
        Assertions.assertEquals(itemEntity.getPrice(), itemDto.getPriceDto());
        Assertions.assertEquals(itemEntity.getCategory(), itemDto.getCategoryDto());
        Assertions.assertEquals(itemEntity.getCountries(), itemDto.getCountriesDto());

    }

    @Test
    void convertDtoToEntityTest(){

        ItemDto itemDto = new ItemDto("iPhone 15 Pro", "Powerful Smartphone", 1000, new Category(1L, "Smartphone"), List.of(new Country(1L, "KZ", "Kazakhstan")));

        Item itemEntity = itemMapper.toEntity(itemDto);

        Assertions.assertNotNull(itemEntity);

        Assertions.assertNotNull(itemEntity.getName());
        Assertions.assertNotNull(itemEntity.getDescription());
        Assertions.assertNotNull(itemEntity.getPrice());
        Assertions.assertNotNull(itemEntity.getCategory());
        Assertions.assertNotNull(itemEntity.getCountries());

        Assertions.assertEquals(itemDto.getNameDto(), itemEntity.getName());
        Assertions.assertEquals(itemDto.getDescriptionDto(), itemEntity.getDescription());
        Assertions.assertEquals(itemDto.getPriceDto(), itemEntity.getPrice());
        Assertions.assertEquals(itemDto.getCategoryDto(), itemEntity.getCategory());
        Assertions.assertEquals(itemDto.getCountriesDto(), itemEntity.getCountries());


    }

    @Test
    void convertEntityListToDtoListTest(){

        List<Item> itemEntityList = new ArrayList<>();
        itemEntityList.add(new Item(1L, "iPhone 15 Pro", "Powerful Smartphone", 1000, new Category(1L, "Smartphone"), List.of(new Country(1L, "KZ", "Kazakhstan"))));
        itemEntityList.add(new Item(2L, "Galaxy S24", "Flagship Android", 900, new Category(1L, "Smartphone"), List.of(new Country(2L, "US", "United States"))));
        itemEntityList.add(new Item(3L, "MacBook Air", "Lightweight laptop", 1200, new Category(2L, "Laptop"), List.of(new Country(3L, "JP", "Japan"))));

        List<ItemDto> itemDtoList = itemMapper.toDtoList(itemEntityList);

        Assertions.assertNotNull(itemDtoList);

        Assertions.assertNotEquals(0, itemDtoList.size());

        Assertions.assertEquals(itemEntityList.size(), itemDtoList.size());

        for (int i = 0; i < itemEntityList.size(); i++) {

            Item itemEntity = itemEntityList.get(i);

            ItemDto itemDto = itemDtoList.get(i);

            Assertions.assertNotNull(itemDto);

            Assertions.assertNotNull(itemDto.getNameDto());
            Assertions.assertNotNull(itemDto.getDescriptionDto());
            Assertions.assertNotNull(itemDto.getPriceDto());
            Assertions.assertNotNull(itemDto.getCategoryDto());
            Assertions.assertNotNull(itemDto.getCountriesDto());

            Assertions.assertEquals(itemEntity.getName(), itemDto.getNameDto());
            Assertions.assertEquals(itemEntity.getDescription(), itemDto.getDescriptionDto());
            Assertions.assertEquals(itemEntity.getPrice(), itemDto.getPriceDto());
            Assertions.assertEquals(itemEntity.getCategory(), itemDto.getCategoryDto());
            Assertions.assertEquals(itemEntity.getCountries(), itemDto.getCountriesDto());

        }

    }



}
