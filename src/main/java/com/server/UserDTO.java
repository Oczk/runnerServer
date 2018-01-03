package com.server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String hashedPassword;
    private List<String> routes;


    public UserDTO(){}

    public UserDTO(String name, String password){
        this.name = name;
        this.hashedPassword = password;
        routes = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getHashedPassword(){
        return hashedPassword;
    }

    public long getId() {
        return id;
    }

    public void addRoute(String route){
        routes.add(route);
    }
}