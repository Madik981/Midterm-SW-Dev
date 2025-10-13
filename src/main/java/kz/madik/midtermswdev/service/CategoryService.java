package kz.madik.midtermswdev.service;

import kz.madik.midtermswdev.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
    void addCategory(CategoryDto itemDto);
    CategoryDto updateById(Long id, CategoryDto itemDto);
    void deleteById(Long id);
}
