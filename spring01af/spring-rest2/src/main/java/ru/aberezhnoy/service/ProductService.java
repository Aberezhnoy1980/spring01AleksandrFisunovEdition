package ru.aberezhnoy.service;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import ru.aberezhnoy.dto.ProductDto;
import ru.aberezhnoy.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Page<Product> findAll(int pageIndex, int pageSize);

    Optional<Product> findById(Long id);

    Product save(Product product);

    void deleteById(Long id);

    List<Product> findWithFilter(Integer minPrice, Integer maxPrice);

    void updateProductFromDto(ProductDto productDto);
}
