package ru.aberezhnoy.service;

import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.Product;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void delete(Product product);

    void increase(Long id);

    void decrease(Long id);
}
