package ru.aberezhnoy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aberezhnoy.model.Item;

@Data
@NoArgsConstructor
public class ItemDto {
    private Long id;
    private String title;
    private int price;
    private String categoryTitle;

    public ItemDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.price = item.getPrice();
        this.categoryTitle = item.getCategory().getTitle();
    }
}
