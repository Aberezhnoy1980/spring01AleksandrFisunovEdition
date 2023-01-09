package ru.aberezhnoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.aberezhnoy.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.price >= :minPrice and p.price <= :maxPrice")
    List<Product> findProductsByPriceBetween(int minPrice, int maxPrice);

    @Query("select p from Product p where p.price >= :minPrice")
    List<Product> findProductsByPriceGreaterThan(int minPrice);

    @Query("select p from Product p where p.price <= :maxPrice")
    List<Product> findProductsByPriceLessThan(int maxPrice);
}
