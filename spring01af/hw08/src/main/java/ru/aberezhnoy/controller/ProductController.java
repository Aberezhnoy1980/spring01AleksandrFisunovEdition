package ru.aberezhnoy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.dto.ProductDto;
import ru.aberezhnoy.exception.ResourceNotFoundException;
import ru.aberezhnoy.model.Category;
import ru.aberezhnoy.model.Product;
import ru.aberezhnoy.service.CategoryService;
import ru.aberezhnoy.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    @GetMapping
    public Page<ProductDto> findAll(@RequestParam(defaultValue = "1", name = "p") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 5).map(ProductDto::new);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> findById(@PathVariable Long id) {
//        Optional<Product> product = productService.findById(id);
//        if (!product.isPresent()) {
//            return new ResponseEntity<>(new MarketError("Product with id = " + id + "not found"), HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(new ProductDto(product.get()), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product with id = " + id + " not found")
                ));
    }

//    @PostMapping
//    public ProductDto save(@RequestBody ProductDto dto) {
//        Product product = new Product();
//        product.setPrice(dto.getPrice());
//        product.setCategory(categoryService
//                .findByTitle(dto.getTitle())
//                .orElseThrow(() -> new ResourceNotFoundException(
//                        "Category with title = " + dto.getCategoryTitle() + " not found")));
//        product.setTitle(dto.getTitle());
//        productService.save(product);
//        return new ProductDto(product);
//    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = categoryService
                .findByTitle(productDto
                        .getCategoryTitle())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category title = " + productDto.getCategoryTitle() + " not found"));
        product.setCategory(category);
        productService.save(product);
        return new ProductDto(product);
    }

    @GetMapping("/delete/{id}")
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
