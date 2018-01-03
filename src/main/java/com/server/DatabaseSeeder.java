package com.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private UserRepository userRepository;

    private UserController userController = new UserController();


    @Autowired
    public DatabaseSeeder(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<UserDTO> users = new ArrayList<>();

        users.add(userController.save("name0", "password0"));
        users.add(userController.save("name2", "password2"));

        userRepository.save(users);
    }




}
