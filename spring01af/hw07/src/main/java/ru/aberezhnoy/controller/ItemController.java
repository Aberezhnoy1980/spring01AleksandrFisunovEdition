package ru.aberezhnoy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.dto.ItemDto;
import ru.aberezhnoy.model.Item;
import ru.aberezhnoy.service.CategoryService;
import ru.aberezhnoy.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;

// не работать с DTO в сервисах
//    @GetMapping("/items")
//    public List<ItemDto> showAll() {
//        return itemService.findAll();
//    }

//     например, использовать стримы
//    @GetMapping("/items")
//    public List<ItemDto> showAll() {
//        return itemService.findAll().stream().map(ItemDto::new).collect(Collectors.toList());
//    }

    //    или обработать в контроллере
//    @GetMapping("/items")
//    public List<ItemDto> showAll() {
//        return itemToItemDto(itemService.findAll());
//    }

    private static List<ItemDto> itemToItemDto(List<Item> itemList) {
        List<ItemDto> dtoList = new ArrayList<>();
        for (Item i : itemList) {
            dtoList.add(new ItemDto(i));
        }
        return dtoList;
    }

//    @GetMapping("/items/{id}")
//    public Optional<ItemDto> findById(@PathVariable Long id) {
//        return itemService.findById(id);
//    }

    @GetMapping("/items")
    public List<ItemDto> findAll(@RequestParam(name = "minPrice", required = false) Integer minPrice,
                                 @RequestParam(name = "maxPrice", required = false) Integer maxPrice) {
        return itemToItemDto(itemService.findWithFiler(minPrice, maxPrice));
    }

//    @PostMapping("/items")
//    public void create(@RequestBody ItemDto dto) {
//        itemService.create(dto);
//    }

    @GetMapping("/items/{id}")
    public ItemDto findById(@PathVariable Long id) {
        return new ItemDto(itemService.findById(id).get());
    }

    @PostMapping("/items")
    public ItemDto save(@RequestBody ItemDto dto) {
        Item item = new Item();
//        Category category = categoryService.findByTitle(dto.getCategoryTitle()).get();
        item.setCategory(categoryService.findByTitle(dto.getCategoryTitle()).get());
        item.setTitle(dto.getTitle());
        item.setPrice(dto.getPrice());
        itemService.save(item);
        return new ItemDto(item);
    }

//    @GetMapping("/items/gfilter")
//    public List<ItemDto> findWithGtFilter(@RequestParam(name = "minPrice") int minPrice) {
//        return itemService.findWithGtFilter(minPrice);
//    }
//
//    @GetMapping("/items/lfilter")
//    public List<ItemDto> findWithLtFilter(@RequestParam(name = "maxPrice") int maxPrice) {
//        return itemService.findWithLtFilter(maxPrice);
//    }
//
//    @GetMapping("/items/bfilter")
//    public List<ItemDto> findWithBwFilter(@RequestParam(name = "minPrice") int minPrice, @RequestParam(name = "maxPrice") int maxPrice) {
//        return itemService.findWithBwFilter(minPrice, maxPrice);
//    }

    @GetMapping("/items/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        itemService.deleteById(id);
    }
}
