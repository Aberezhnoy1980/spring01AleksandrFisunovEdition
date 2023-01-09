package ru.aberezhnoy.demo1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class InMemoryItemRepository implements IItemRepository{

    private List<Item> items;

    @PostConstruct
    public void init() {
        items = new ArrayList<>(Arrays.asList(
                new Item(1L, "Milk", 85),
                new Item(2L, "Bread", 25),
                new Item(3L, "Butter", 55),
                new Item(4L, "Meat", 35),
                new Item(5L, "Sugar", 65)
        ));
    }

    @Override
    public Item findById(Long id) {
        return items.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public void save(Item item) {
        Long newId = items.stream().mapToLong(Item::getId).max().getAsLong() + 1;
        item.setId(newId);
        items.add(item);
    }
}
