package ru.aberezhnoy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.Student;
import ru.aberezhnoy.repository.StudentsRepository;

import java.util.List;

@Service
public class StudentsService {
    private StudentsRepository studentsrepository;

    @Autowired
    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsrepository = studentsRepository;
    }

    public List<Student> findAll() {
        return studentsrepository.findAll();
    }

    public Student findById(Long id) {
        return studentsrepository.findById(id);
    }

    public void save(Student student) {
        studentsrepository.save(student);
    }

}
