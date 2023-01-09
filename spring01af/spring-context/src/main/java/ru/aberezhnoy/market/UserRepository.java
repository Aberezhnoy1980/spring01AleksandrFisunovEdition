package ru.aberezhnoy.market;

import org.springframework.stereotype.Component;

@Component
public interface UserRepository {
    User findByUsername(String username);
}
