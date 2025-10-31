package com.github.nicolasholanda.spring_jdbc.controller;

import com.github.nicolasholanda.spring_jdbc.model.User;
import com.github.nicolasholanda.spring_jdbc.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/with-orders-n-plus-one")
    public List<User> getUsersWithOrdersNPlusOne() {
        List<User> users = userRepository.findAll();

        users.forEach(user -> {
            user.getOrders().size();
        });

        return users;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

