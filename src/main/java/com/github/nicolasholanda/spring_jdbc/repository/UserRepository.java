package com.github.nicolasholanda.spring_jdbc.repository;

import com.github.nicolasholanda.spring_jdbc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
