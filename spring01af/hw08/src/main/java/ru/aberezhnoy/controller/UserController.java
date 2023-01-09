package ru.aberezhnoy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.aberezhnoy.dto.ProductDto;
import ru.aberezhnoy.dto.UserDto;
import ru.aberezhnoy.exception.ResourceNotFoundException;
import ru.aberezhnoy.model.User;
import ru.aberezhnoy.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<UserDto> findAll(@RequestParam(required = false, name = "minAge") Optional<Integer> minAge,
                                 @RequestParam(required = false, name = "maxAge") Optional<Integer> maxAge,
                                 @RequestParam(required = false, name = "male") Optional<String> male,
                                 @RequestParam(defaultValue = "1", name = "u") int index) {
        if (index < 1) {
            index = 1;
        }
        return userService.findAll(minAge, maxAge, male, index - 1, 5).map(UserDto::new);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return new UserDto(userService.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "User with id = " + id + " not found")
        ));
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setMale(dto.getMale());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        userService.save(user);
        return new UserDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}







