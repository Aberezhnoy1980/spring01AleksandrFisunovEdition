package ru.aberezhnoy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.dto.ProductDto;
import ru.aberezhnoy.model.Product;
import ru.aberezhnoy.service.CategoryService;
import ru.aberezhnoy.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

//    @GetMapping("/products")
//    public List<ProductDto> findAll(@RequestParam(required = false) Integer minPrice,
//                                    @RequestParam(required = false) Integer maxPrice) {
//        return productToProductDto(productService.findWithFilter(minPrice, maxPrice));
//    }

    @GetMapping("/products")
    public Page<ProductDto> findAll(@RequestParam(defaultValue = "1", name = "p") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 5).map(ProductDto::new);
    }

    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id).get());
    }

    @PostMapping("/products")
    public ProductDto save(@RequestBody ProductDto dto) {
        Product product = new Product();
        product.setPrice(dto.getPrice());
        product.setCategory(categoryService.findByTitle(dto.getTitle()).get());
        product.setTitle(dto.getTitle());
        productService.save(product);
        return new ProductDto(product);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    private List<ProductDto> productToProductDto(List<Product> productList) {
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product p : productList) {
            dtoList.add(new ProductDto(p));
        }
        return dtoList;
    }
}
