package ru.aberezhnoy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.aberezhnoy.model.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    @NotNull(message = "The product must have a name")
    @Length(min = 3, max = 255, message = "Name length should consist from 3 to 255 characters")
    private String title;

    @Min(value = 1, message = "Price cannot be less than 1 point")
    private int price;

    @NotNull(message = "The product must have a category name")
    private String categoryTitle;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.categoryTitle = product.getCategory().getTitle();
    }
}
