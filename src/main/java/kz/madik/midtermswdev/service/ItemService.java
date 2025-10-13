package kz.madik.midtermswdev.service;

import kz.madik.midtermswdev.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAll();
    ItemDto getById(Long id);
    void addItem(ItemDto itemDto);
    ItemDto updateById(Long id, ItemDto itemDto);
    void deleteById(Long id);
}
