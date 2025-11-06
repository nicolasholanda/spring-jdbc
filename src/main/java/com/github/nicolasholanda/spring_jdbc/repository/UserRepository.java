package com.github.nicolasholanda.spring_jdbc.repository;

import com.github.nicolasholanda.spring_jdbc.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.orders")
    List<User> findAllWithOrdersJoinFetch();

    @EntityGraph(attributePaths = "orders")
    List<User> findAllWithOrdersEntityGraph();
}
