package ru.aberezhnoy.demo1;

import org.springframework.stereotype.Component;

import java.util.List;

// bean name - dbItemRepository
@Component(value = "dbRepo")
public class DbItemRepository implements IItemRepository {
    @Override
    public Item findById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Item> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(Item item) {
        throw new UnsupportedOperationException();
    }
}
