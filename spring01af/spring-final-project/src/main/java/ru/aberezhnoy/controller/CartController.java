package ru.aberezhnoy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.cart.CartService;
import ru.aberezhnoy.dto.ItemDto;
import ru.aberezhnoy.dto.ProductDto;
import ru.aberezhnoy.model.Item;
import ru.aberezhnoy.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productToProductDto(cartService.findAll());
    }

    @PostMapping
    public void addToCart(@RequestBody ProductDto productDto) {
        cartService.addToCart(productDto.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        cartService.deleteItemById(id);
    }

    private static List<ProductDto> productToProductDto(List<Product> productList) {
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product p : productList) {
            dtoList.add(new ProductDto(p));
        }
        return dtoList;
    }
}
