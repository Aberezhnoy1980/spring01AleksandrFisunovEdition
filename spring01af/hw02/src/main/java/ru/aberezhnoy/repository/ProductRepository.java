package ru.aberezhnoy.repository;

import org.springframework.stereotype.Repository;
import ru.aberezhnoy.model.Product;

import java.util.List;

@Repository
public interface ProductRepository {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void delete(Product product);
}
