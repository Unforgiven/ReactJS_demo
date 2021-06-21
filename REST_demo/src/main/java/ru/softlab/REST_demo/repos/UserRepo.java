package ru.softlab.REST_demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.softlab.REST_demo.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
