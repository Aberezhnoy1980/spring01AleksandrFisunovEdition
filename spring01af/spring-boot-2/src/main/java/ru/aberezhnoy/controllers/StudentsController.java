package ru.aberezhnoy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.model.Student;
import ru.aberezhnoy.services.StudentsService;

@Controller
@RequestMapping("/students")
public class StudentsController {

    private StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    //GET [localhost:8080/app]/students/{id}
    @GetMapping("/students/{id}")
    @ResponseBody
    public Student getStudentInfo(@PathVariable Long id) {
        return new Student(id, "Bob", 100);
    }

    //GET [localhost:8080/app]/show
    @GetMapping("/show_all")
    public String showStudentsPage(Model model) {
        model.addAttribute("students", studentsService.findAll());
        return "students";
    }

    //GET [localhost:8080/app]/show
    @GetMapping("/show/{id}")
    public String showStudentsInfo(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentsService.findById(id));
        return "student_info";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create_student";
    }

//    @PostMapping("/create")
//    public String saveStudent(@RequestParam Long id, @RequestParam String name, @RequestParam int score) {
//        Student student = new Student(id, name, score);
//        studentsService.save(student);
//        return "redirect:/show_all";
//    }

    @PostMapping("/create")
    public String saveStudent(@ModelAttribute Student student) {
        studentsService.save(student);
        return "redirect:/students/show_all";
    }

    @GetMapping("/json/{id}")
    @ResponseBody
    public Student findById(@PathVariable Long id) {
        return studentsService.findById(id);
    }

    @PostMapping("/json")
    @ResponseBody
    public void saveJsonStudent(@RequestBody Student student) {
        studentsService.save(student);
    }
}
