package ru.aberezhnoy.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.Product;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Page<Product> findAll(int pageIndex, int pageSize);

    Optional<Product> findById(Long id);

    Product save(Product product);

    void deleteById(Long id);

    List<Product> findWithFilter(Integer minPrice, Integer maxPrice);
}
