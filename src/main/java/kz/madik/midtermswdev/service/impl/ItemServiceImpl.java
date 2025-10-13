package kz.madik.midtermswdev.service.impl;

import kz.madik.midtermswdev.dto.ItemDto;
import kz.madik.midtermswdev.entity.Item;
import kz.madik.midtermswdev.mapper.ItemMapper;
import kz.madik.midtermswdev.repository.ItemRepository;
import kz.madik.midtermswdev.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemDto> getAll() {
        return itemMapper.toDtoList(itemRepository.findAll());
    }

    @Override
    public ItemDto getById(Long id) {
        return itemMapper.toDto(itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found")));
    }

    @Override
    public void addItem(ItemDto itemDto) {
        itemRepository.save(itemMapper.toEntity(itemDto));
    }

    @Override
    public ItemDto updateById(Long id, ItemDto itemDto) {
        Item item = itemMapper.toEntity(itemDto);

        Item updateItem = itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));

        updateItem.setName(item.getName());
        updateItem.setDescription(item.getDescription());
        updateItem.setPrice(item.getPrice());
        updateItem.setCategory(item.getCategory());
        updateItem.setCountries(item.getCountries());

        return itemMapper.toDto(itemRepository.save(updateItem));
    }

    @Override
    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}
