package com.github.nicolasholanda.spring_jdbc;

import com.github.nicolasholanda.spring_jdbc.model.Order;
import com.github.nicolasholanda.spring_jdbc.model.User;
import com.github.nicolasholanda.spring_jdbc.repository.OrderRepository;
import com.github.nicolasholanda.spring_jdbc.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(UserRepository userRepository, OrderRepository orderRepository) {
		return args -> {
			for (int i = 1; i <= 10; i++) {
				User user = new User("User " + i, "user" + i + "@example.com");
				User savedUser = userRepository.save(user);

				for (int j = 1; j <= 5; j++) {
					Order order = new Order(
						BigDecimal.valueOf(100.00 + (i * j)),
						savedUser
					);
					orderRepository.save(order);
				}
			}
		};
	}
}
