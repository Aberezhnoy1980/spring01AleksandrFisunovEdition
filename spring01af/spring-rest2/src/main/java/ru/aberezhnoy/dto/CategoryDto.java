package ru.aberezhnoy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aberezhnoy.model.Category;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoryDto {

    private Long id;

    private String title;

    private List<ProductDto> products;

    private List<ItemDto> items;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.products = category.getProducts().stream()
                .map(ProductDto::new)
                .collect(Collectors
                        .toList());
        this.items = category.getItems().stream()
                .map(ItemDto::new)
                .collect(Collectors
                        .toList());
    }


}
