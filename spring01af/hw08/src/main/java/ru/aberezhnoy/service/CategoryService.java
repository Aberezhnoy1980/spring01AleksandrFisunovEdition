package ru.aberezhnoy.service;

import ru.aberezhnoy.model.Category;

import java.util.Optional;

public interface CategoryService {

    Optional<Category> findByTitle(String title);

    Optional<Category> findById(Long id);

    Optional<Category> findByIdWithProducts(Long id);
}
