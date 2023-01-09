package ru.aberezhnoy.cart;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.aberezhnoy.model.Product;

import java.util.List;

@Component
public interface CartService {
    void addToCart(Long id);

    void deleteItemById(Long id);

    List<Product> findAll();
}
