package ru.aberezhnoy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    // GET [http://localhost:8189/app]/add?x=10&y=20
    @GetMapping("/add")
    @ResponseBody
    public int addTwoNumbers(@RequestParam(name = "x") int a, @RequestParam(name = "y") int b) {
        return a + b;
    }

    @GetMapping("/sub")
    @ResponseBody
    public int subTwoNumbers(@RequestParam(defaultValue = "0") int a, @RequestParam(required = false) int b) {
        return a - b;
    }

    @GetMapping("/page")
    public String showHtmlPage() {
        return "myHtml";
    }

    @GetMapping("/product")
    @ResponseBody
    public Product getProduct() {
        return new Product(1L, "Milk", 100);
    }
}
