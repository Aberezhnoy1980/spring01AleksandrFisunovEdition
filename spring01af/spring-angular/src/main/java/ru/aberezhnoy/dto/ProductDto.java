package ru.aberezhnoy.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.aberezhnoy.model.Category;
import ru.aberezhnoy.model.Product;

@Data
public class ProductDto {

    private Long id;

    private String title;

    private int price;

    private String category;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory().getTitle();
    }
}
