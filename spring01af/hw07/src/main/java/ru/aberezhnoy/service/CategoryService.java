package ru.aberezhnoy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.Category;
import ru.aberezhnoy.repository.CategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
