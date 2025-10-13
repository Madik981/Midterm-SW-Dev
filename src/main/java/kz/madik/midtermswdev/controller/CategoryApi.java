package kz.madik.midtermswdev.controller;

import kz.madik.midtermswdev.dto.CategoryDto;
import kz.madik.midtermswdev.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryApi {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(
            @PathVariable("id") Long id
    ) {
        try {
            return ResponseEntity.ok(categoryService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void addCategory(
            @RequestBody CategoryDto categoryDto
    ) {
        categoryService.addCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateById(
            @PathVariable("id") Long id,
            @RequestBody CategoryDto categoryDto
    ) {
        try {
            return ResponseEntity.ok(categoryService.updateById(id, categoryDto));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable("id") Long id
    ) {
        categoryService.deleteById(id);
    }
}
