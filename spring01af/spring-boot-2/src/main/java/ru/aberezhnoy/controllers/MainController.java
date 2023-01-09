package ru.aberezhnoy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/students")
    public String showIndexPage() {
        return "index";
    }

    //root = localhost:8080/app

    //GET [localhost:8080/app]/info
    @GetMapping("/info")
    @ResponseBody
    public String demoInfo() {
        return "Hello, world!!!";
    }

    //GET [localhost:8080/app]/echo?word=Auuuu&zzz=123
    @GetMapping("/echo")
    @ResponseBody
    public String echoRequestWithRequestParam(@RequestParam(name = "word") String word, @RequestParam(name = "zzz") int value) {
        return "Echo: " + word + " " + value;
    }
}
