package ru.aberezhnoy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.model.User;
import ru.aberezhnoy.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findAll(Optional<Integer> minAge, Optional<Integer> maxAge, Optional<String> male, Integer index, Integer size) {
        if (male.isPresent())
            return userRepository.findUsersByMale(male.get(), PageRequest.of(index, size));

        if (minAge.isPresent() && maxAge.isEmpty())
            return userRepository.findUsersByAgeGreaterThan(minAge.get(), PageRequest.of(index, size));

        if (minAge.isEmpty() && maxAge.isPresent())
            return userRepository.findUsersByAgeLessThan(maxAge.get(), PageRequest.of(index, size));

        if (minAge.isPresent() && maxAge.isPresent())
            return userRepository.findUsersByAgeBetweenThan(minAge.get(), maxAge.get(), PageRequest.of(index, size));

        return userRepository.findAll(PageRequest.of(index, size));
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
