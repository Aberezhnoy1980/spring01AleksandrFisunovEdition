package ru.aberezhnoy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.aberezhnoy.model.Category;
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
