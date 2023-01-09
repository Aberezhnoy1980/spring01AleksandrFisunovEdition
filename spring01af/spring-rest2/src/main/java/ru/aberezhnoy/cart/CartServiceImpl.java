package ru.aberezhnoy.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.aberezhnoy.exception.ResourceNotFoundException;
import ru.aberezhnoy.model.Product;
import ru.aberezhnoy.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class CartServiceImpl implements CartService {

    private final List<Product> cart;

    private final ProductService productService;

    @Autowired
    public CartServiceImpl(ProductService productService) {
        this.cart = new ArrayList<>();
        this.productService = productService;
    }

    @Override
    public List<Product> findAll() {
        return cart;
    }

    @Override
    public void addToCart(Long id) {
        cart.add(productService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product with id = " + id + " not found")
                ));
    }

    @Override
    public void deleteItemById(Long id) {
        cart.remove(productService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product with id = " + id + " not found")
                ));
    }

}







