package ru.aberezhnoy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aberezhnoy.dto.CategoryDto;
import ru.aberezhnoy.exception.ResourceNotFoundException;
import ru.aberezhnoy.service.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return new CategoryDto(categoryService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categories with id " + id + " not found")));
    }
}
