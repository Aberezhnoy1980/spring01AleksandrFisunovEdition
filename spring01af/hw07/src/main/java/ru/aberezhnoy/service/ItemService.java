package ru.aberezhnoy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.Item;
import ru.aberezhnoy.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
//    private final CategoryService categoryService;

    // не работать с DTO в сервисах
//    public List<ItemDto> findAll() {
//        List<ItemDto> dtoList = new ArrayList<>();
//        for (Item i : itemRepository.findAll()) {
//            dtoList.add(new ItemDto(i));
//        }
//        return dtoList;
//    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

//    public Optional<ItemDto> findById(Long id) {
//        return Optional.of(new ItemDto(itemRepository.findById(id).get()));
//    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

//    public void create(ItemDto dto) {
//        Item item = new Item();
//        Category cat = categoryService.findByTitle(dto.getCategoryTitle()).get();
//        item.setTitle(dto.getTitle());
//        item.setPrice(dto.getPrice());
//        item.setCategory(cat);
//        itemRepository.save(item);
////        return new ItemDto(itemRepository.save(item));
//    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

//    public List<ItemDto> findWithGtFilter(int minPrice) {
//        List<ItemDto> listFilteredDto = new ArrayList<>();
//        for (Item i : itemRepository.findItemsByPriceGreaterThan(minPrice)) {
//            listFilteredDto.add(new ItemDto(i));
//        }
//        return listFilteredDto;
//    }
//
//    public List<ItemDto> findWithLtFilter(int maxPrice) {
//        List<ItemDto> listFilteredDto = new ArrayList<>();
//        for (Item i : itemRepository.findItemsByPriceLessThan(maxPrice)) {
//            listFilteredDto.add(new ItemDto(i));
//        }
//        return listFilteredDto;
//    }
//
//    public List<ItemDto> findWithBwFilter(int minPrice, int maxPrice) {
//        List<ItemDto> listFilteredDto = new ArrayList<>();
//        for (Item i : itemRepository.findItemsByPriceBetween(minPrice, maxPrice)) {
//            listFilteredDto.add(new ItemDto(i));
//        }
//        return listFilteredDto;
//    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
//        itemRepository.delete(itemRepository.findById(id).get());
    }

    public List<Item> findWithFiler(Integer minPrice, Integer maxPrice) {
        if (maxPrice == null && minPrice != null) {
            return itemRepository.findItemsByPriceGreaterThan(minPrice);
        } else if (minPrice == null && maxPrice != null) {
            return itemRepository.findItemsByPriceLessThan(maxPrice);
        } else if (minPrice != null && maxPrice != null) {
            return itemRepository.findItemsByPriceBetween(minPrice, maxPrice);
        }
        return itemRepository.findAll();
    }
}
