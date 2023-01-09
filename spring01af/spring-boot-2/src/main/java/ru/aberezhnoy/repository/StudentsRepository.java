package ru.aberezhnoy.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.aberezhnoy.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class StudentsRepository {
    private List<Student> students;

    @PostConstruct
    public void init() {
        this.students = new ArrayList<>(Arrays.asList(
                new Student(1L, "Bob", 80),
                new Student(2L, "Jack", 90),
                new Student(3L, "John", 100),
                new Student(4L, "Max", 90)
        ));
    }

    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    public Student findById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    public void save(Student student) {
        students.add(student);
    }
}
