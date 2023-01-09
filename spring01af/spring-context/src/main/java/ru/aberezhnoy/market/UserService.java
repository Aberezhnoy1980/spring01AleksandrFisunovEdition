package ru.aberezhnoy.market;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
    // @Autowired UserRepository userRepository;

    User findByUsername(String username);
}
