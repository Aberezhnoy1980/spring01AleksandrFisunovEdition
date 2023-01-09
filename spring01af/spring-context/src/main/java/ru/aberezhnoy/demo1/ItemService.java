package ru.aberezhnoy.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {

    private final IItemRepository itemRepository;
    @Value("1234567")
    private String string;

    @Autowired
    public ItemService(@Qualifier(value = "inMemoryItemRepository") IItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public int getSumPrice() {
        return itemRepository.findAll().stream().mapToInt(Item::getPrice).sum();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public void save(Item item) {
        itemRepository.save(item);
    }
}
