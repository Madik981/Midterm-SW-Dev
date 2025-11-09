package kz.madik.midtermswdev.service;

import kz.madik.midtermswdev.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAll();
    ItemDto getById(Long id);
    ItemDto addItem(ItemDto itemDto);
    ItemDto updateById(Long id, ItemDto itemDto);
    boolean deleteById(Long id);
}
