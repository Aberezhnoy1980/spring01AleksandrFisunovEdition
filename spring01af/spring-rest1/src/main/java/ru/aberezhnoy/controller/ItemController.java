package ru.aberezhnoy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.dto.ItemDto;
import ru.aberezhnoy.exception.ResourceNotFoundException;
import ru.aberezhnoy.model.Category;
import ru.aberezhnoy.model.Item;
import ru.aberezhnoy.service.CategoryService;
import ru.aberezhnoy.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    private final CategoryService categoryService;

    private static List<ItemDto> itemToItemDto(List<Item> itemList) {
        List<ItemDto> dtoList = new ArrayList<>();
        for (Item i : itemList) {
            dtoList.add(new ItemDto(i));
        }
        return dtoList;
    }

    @GetMapping
    public List<ItemDto> findAll(@RequestParam(name = "minPrice", required = false) Integer minPrice,
                                 @RequestParam(name = "maxPrice", required = false) Integer maxPrice) {
        return itemToItemDto(itemService.findWithFilter(minPrice, maxPrice));
    }

    @GetMapping("/{id}")
    public ItemDto findById(@PathVariable Long id) {
        return new ItemDto(itemService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Item with id " + id + " not found")));
    }

    @PostMapping
    public ItemDto save(@RequestBody ItemDto dto) {
        Item item = new Item();
        Category category = categoryService
                .findByTitle(dto
                        .getCategoryTitle())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category title = " + dto.getCategoryTitle() + " not found"));
        item.setCategory(category);
        item.setTitle(dto.getTitle());
        item.setPrice(dto.getPrice());
        itemService.save(item);
        return new ItemDto(item);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        itemService.deleteById(id);
    }
}
