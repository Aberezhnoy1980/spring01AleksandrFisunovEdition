package ru.aberezhnoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.dto.ProductDto;
import ru.aberezhnoy.model.Category;
import ru.aberezhnoy.model.Product;
import ru.aberezhnoy.repository.CategoryRepository;
import ru.aberezhnoy.repository.ProductRepository;
import ru.aberezhnoy.service.CategoryService;
import ru.aberezhnoy.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("products/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id).get());
    }

    @PostMapping("/products")
    public ProductDto save(@RequestBody ProductDto dto) {
        Product product = new Product();
        product.setPrice(dto.getPrice());
        product.setTitle(dto.getTitle());
        Category category = categoryService.findByTitle(dto.getCategoryTitle()).get();
        product.setCategory(category);
        productService.save(product);
        return new ProductDto(product);
    }
}
