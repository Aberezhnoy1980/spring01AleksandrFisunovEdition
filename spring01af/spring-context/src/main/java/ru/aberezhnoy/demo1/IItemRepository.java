package ru.aberezhnoy.demo1;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IItemRepository {

    Item findById(Long id);

    List<Item> findAll();

    void save(Item item);

}
