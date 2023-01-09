package ru.aberezhnoy.demo1.cart;

import org.springframework.stereotype.Component;

@Component
public interface CartService {
    void addToCart(Long id);

    void deleteItemById(Long id);

    void showOrder();
}
