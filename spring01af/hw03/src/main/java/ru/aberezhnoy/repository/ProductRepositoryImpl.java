package ru.aberezhnoy.repository;

import org.springframework.stereotype.Repository;
import ru.aberezhnoy.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> catalog;

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(catalog);
    }

    @Override
    public Product findById(Long id) {
        return catalog.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    @Override
    public void save(Product product) {
        catalog.add(product);
    }

    @Override
    public void delete(Product product) {
        catalog.remove(product);
    }

    @PostConstruct
    public void init() {
        this.catalog = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", 87),
                new Product(2L, "Bread", 30),
                new Product(3L, "Sausage", 30),
                new Product(4L, "Cheese", 279)
        ));
    }
}
