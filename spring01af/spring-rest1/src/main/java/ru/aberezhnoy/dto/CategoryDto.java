package ru.aberezhnoy.dto;

import lombok.Data;
import ru.aberezhnoy.model.Category;

@Data
public class CategoryDto {

    private Long id;

    private String title;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
    }
}
