package ru.aberezhnoy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.Category;
import ru.aberezhnoy.repository.CategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> findByIdWithProducts(Long id) {
        return categoryRepository.findByIdWithProducts(id);
    }
}
