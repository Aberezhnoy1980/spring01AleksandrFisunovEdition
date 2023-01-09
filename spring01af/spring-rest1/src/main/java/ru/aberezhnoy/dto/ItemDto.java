package ru.aberezhnoy.dto;

import lombok.Data;
import ru.aberezhnoy.model.Item;

@Data
public class ItemDto {

    private Long id;

    private String title;

    private int price;

    private String category;

    public ItemDto(Item item) {
        this.id = item.getId();
        this.category = item.getCategory().getTitle();
        this.price = item.getPrice();
        this.title = item.getTitle();
    }
}
