package ru.aberezhnoy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.NotFoundException;
import ru.aberezhnoy.controller.dto.StudentDto;
import ru.aberezhnoy.persist.StudentRepository;
import ru.aberezhnoy.persist.StudentSpecification;
import ru.aberezhnoy.persist.model.Student;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private static StudentDto convertToDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getAge()
        );
    }

    @Override
    public Page<StudentDto> findAll(Optional<String> nameFilter, Optional<Integer> minAgeFilter, Optional<Integer> maxAgeFilter, Integer page, Integer size, String sort) {
        Specification<Student> spec = Specification.where(null);
        if (nameFilter.isPresent() && !nameFilter.get().isBlank()) {
            spec = spec.and(StudentSpecification.nameLike(nameFilter.get()));
        }

        if (minAgeFilter.isPresent()) {
            spec = spec.and(StudentSpecification.minAgeFilter(minAgeFilter.get()));
        }

        if (maxAgeFilter.isPresent()) {
            spec = spec.and(StudentSpecification.maxAgeFilter(maxAgeFilter.get()));
        }
        return studentRepository.findAll(spec, PageRequest.of(page, size, Sort.by(sort)))
                .map(StudentServiceImpl::convertToDto);
    }

    @Override
    public Optional<StudentDto> findById(Long id) {
        return studentRepository.findById(id)
                .map(StudentServiceImpl::convertToDto);
    }

    @Override
    public void save(StudentDto studentDto) {
        Student student = (studentDto.getId() != null) ? studentRepository.findById(studentDto.getId())
                .orElseThrow(() -> new NotFoundException("")) : new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
