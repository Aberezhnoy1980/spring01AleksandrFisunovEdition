package ru.aberezhnoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.model.Product;
import ru.aberezhnoy.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/all/{id}")
    public String showProductInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product_info";
    }

    @GetMapping("/create")
    public String getCreateForm() {
        return "create_product";
    }

    @PostMapping("/create")
    public String addNewProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int price) {
        productService.save(new Product(id, title, price));
        return "redirect:/all";
    }

    @GetMapping("/increase/{id}")
    public String increasePrice(@PathVariable Long id) {
        productService.increase(id);
        return "redirect:/all";
    }

    @GetMapping("/decrease/{id}")
    public String decreasePrice(@PathVariable Long id) {
        productService.decrease(id);
        return "redirect:/all";
    }
}
