package ru.aberezhnoy.dto;

import lombok.Data;
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
