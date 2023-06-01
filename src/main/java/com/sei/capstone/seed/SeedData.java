package com.sei.capstone.seed;


import com.sei.capstone.model.User;
import com.sei.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class SeedData implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public SeedData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }

    private void createUsers() {
        User user = new User();
        user.setId(1L);
        user.setEmail("suresh@ga.com");
        user.setPassword(encoder.encode("suresh"));
        userRepository.save(user);
        System.out.println("Users created successfully!");
    }
}
