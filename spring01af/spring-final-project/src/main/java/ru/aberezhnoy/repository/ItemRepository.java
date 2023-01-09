package ru.aberezhnoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.aberezhnoy.model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.price >= :minPrice and i.price <= :maxPrice")
    List<Item> findItemsByPriceBetween(int minPrice, int maxPrice);

    @Query("select i from Item i where i.price >= :minPrice")
    List<Item> findItemsByPriceGreaterThan(int minPrice);

    @Query("select i from Item i where i.price <= :maxPrice")
    List<Item> findItemsByPriceLessThan(int maxPrice);
}
