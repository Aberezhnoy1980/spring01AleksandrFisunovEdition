package ru.aberezhnoy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.User;

import java.util.Optional;

@Service
public interface UserService {

    Page<User> findAll(Optional<Integer> minAge, Optional<Integer> maxAge, Optional<String> male, Integer index, Integer size);

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
