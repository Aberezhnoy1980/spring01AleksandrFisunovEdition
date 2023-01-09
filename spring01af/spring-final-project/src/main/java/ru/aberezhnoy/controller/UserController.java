package ru.aberezhnoy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aberezhnoy.configs.SecurityConfig;
import ru.aberezhnoy.dto.ProductDto;
import ru.aberezhnoy.dto.UserDto;
import ru.aberezhnoy.exception.DataValidationException;
import ru.aberezhnoy.model.User;
import ru.aberezhnoy.service.UserService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reg")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final SecurityConfig securityConfig;

    @PostMapping
    public UserDto addNewUser(@RequestBody @Validated UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataValidationException(bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList()));
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(securityConfig.passwordEncoder().encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        userService.save(user);
        return new UserDto(user);
    }
}
