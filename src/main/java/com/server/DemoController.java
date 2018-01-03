package com.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private UserRepository userRepository;

    @Autowired
    public DemoController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserDTO> getAll(){
        return userRepository.findAll();
    }


    @RequestMapping("/add/{name}/{password}")
    public List<UserDTO> adding(@PathVariable String name, @PathVariable String password){

        UserController userController = new UserController();

            userRepository.save(userController.save(name, password));

        return userRepository.findAll();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<UserDTO> remove(@PathVariable long id){
        userRepository.delete(id);
        return userRepository.findAll();
    }
}
