package com.server;

import com.google.common.hash.Hashing;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class UserController {


    public UserController(){
    }

    public UserDTO save(String name, String password){
        return new UserDTO(name, hashPassword(name, password));
    }

    private String hashPassword(String name, String password){
        return Hashing.sha256().hashString(name+password, StandardCharsets.UTF_8).toString();
    }

}
