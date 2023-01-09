package ru.aberezhnoy.market;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemService {
    List<Item> findByIds(List<Long> id);
}
