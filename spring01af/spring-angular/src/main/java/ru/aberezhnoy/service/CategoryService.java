package ru.aberezhnoy.service;

import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.Category;

import java.util.Optional;

@Service
public interface CategoryService {

    Optional<Category> findByTitle(String title);

    Optional<Category> findById(Long id);

    Optional<Category> findByIdWithProducts(Long id);
}
