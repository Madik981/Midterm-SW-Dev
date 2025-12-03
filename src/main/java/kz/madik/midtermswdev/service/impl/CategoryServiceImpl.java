package kz.madik.midtermswdev.service.impl;

import kz.madik.midtermswdev.dto.CategoryDto;
import kz.madik.midtermswdev.entity.Category;
import kz.madik.midtermswdev.mapper.CategoryMapper;
import kz.madik.midtermswdev.repository.CategoryRepository;
import kz.madik.midtermswdev.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAll() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    @Override
    public CategoryDto getById(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).orElse(null));
    }

    @Override
    public CategoryDto addCategory(CategoryDto countryDto) {
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(countryDto)));
    }

    @Override
    public CategoryDto updateById(Long id, CategoryDto countryDto) {
        Category category = categoryMapper.toEntity(countryDto);

        Category updateCategory = categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found"));

        updateCategory.setCategory(category.getCategory());

        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public boolean deleteById(Long id) {
        categoryRepository.deleteById(id);

        Category category = categoryRepository.findById(id).orElse(null);

        return category == null;
    }
}
