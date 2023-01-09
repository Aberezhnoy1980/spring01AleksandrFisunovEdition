package ru.aberezhnoy.service;

import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.Item;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {

    List<Item> findAll();

    Optional<Item> findById(Long id);

    Item save(Item item);

    void deleteById(Long id);

    List<Item> findWithFilter(Integer minPrice, Integer maxPrice);
}
