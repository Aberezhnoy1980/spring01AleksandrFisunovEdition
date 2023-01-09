package ru.aberezhnoy.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.controller.dto.StudentDto;

import java.util.Optional;

@Service
public interface StudentService {

    Page<StudentDto> findAll(Optional<String> nameFilter, Optional<Integer> minAgeFilter, Optional<Integer> maxAgeFilter, Integer page, Integer size, String sort);

    Optional<StudentDto> findById(Long id);

    void save(StudentDto studentDto);

    void deleteById(Long id);
}
