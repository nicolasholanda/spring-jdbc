package com.github.nicolasholanda.spring_jdbc.controller;

import com.github.nicolasholanda.spring_jdbc.model.User;
import com.github.nicolasholanda.spring_jdbc.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/with-orders-n-plus-one")
    public Map<String, Object> getUsersWithOrdersNPlusOne() {
        long startTime = System.currentTimeMillis();
        List<User> users = userRepository.findAll();

        users.forEach(user -> {
            user.getOrders().size();
        });

        long endTime = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<>();
        response.put("data", users);
        response.put("executionTime", endTime - startTime);
        response.put("method", "N+1 Problem");
        return response;
    }

    @GetMapping("/with-orders-join-fetch")
    public Map<String, Object> getUsersWithOrdersJoinFetch() {
        long startTime = System.currentTimeMillis();
        List<User> users = userRepository.findAllWithOrdersJoinFetch();

        users.forEach(user -> {
            user.getOrders().size();
        });

        long endTime = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<>();
        response.put("data", users);
        response.put("executionTime", endTime - startTime);
        response.put("method", "JOIN FETCH");
        return response;
    }

    @GetMapping("/with-orders-entity-graph")
    public Map<String, Object> getUsersWithOrdersEntityGraph() {
        long startTime = System.currentTimeMillis();
        List<User> users = userRepository.findAllWithOrdersEntityGraph();

        users.forEach(user -> {
            user.getOrders().size();
        });

        long endTime = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<>();
        response.put("data", users);
        response.put("executionTime", endTime - startTime);
        response.put("method", "@EntityGraph");
        return response;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

