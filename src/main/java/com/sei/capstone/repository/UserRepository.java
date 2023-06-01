package com.sei.capstone.repository;

import com.sei.capstone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    boolean existsByEmail(String email);
    User findUserByEmail(String email);

}
