package ru.aberezhnoy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.NotFoundException;
import ru.aberezhnoy.controller.dto.StudentDto;
import ru.aberezhnoy.service.StudentService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listPage(Model model,
                           @RequestParam("nameFilter") Optional<String> nameFilter,
                           @RequestParam("minAgeFilter") Optional<Integer> minAgeFilter,
                           @RequestParam("maxAgeFilter") Optional<Integer> maxAgeFilter,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size,
                           @RequestParam("sort") Optional<String> sort) {
        logger.info("Student filter with name pattern {} ", nameFilter.orElse(null));

        model.addAttribute("students", studentService.findAll(
                nameFilter,
                minAgeFilter,
                maxAgeFilter,
                page.orElse(1) - 1,
                size.orElse(5),
                sort.filter(s -> !s.isBlank()).orElse("id")
        ));
        return "student";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found")));
        return "student_form";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("student", new StudentDto());
        return "student_form";
    }

    @PostMapping
    public String save(@Valid StudentDto student, BindingResult result) {
        if (result.hasErrors()) {
            return "student_form";
        }
        studentService.save(student);
        return "redirect:/student";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return "redirect:/student";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler(NotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "not_found";
    }
}
