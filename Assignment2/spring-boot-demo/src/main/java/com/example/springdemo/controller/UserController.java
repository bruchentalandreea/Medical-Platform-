package com.example.springdemo.controller;


import com.example.springdemo.entities.User;
import com.example.springdemo.errorhandler.NotFoundException;
import com.example.springdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/ceva")
    public String getCeva() {
        return "ceva";
    }

    /**
     * Ia datele din baza de date
     * @return o lista de Admini
     */

    @GetMapping("/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addUser(@Valid @RequestBody  User user) {
        userRepository.save(user);
        return"Succes";
    }


    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@Valid @RequestBody  User user) {
        userRepository.delete(user);
        return "User deleted";
    }

    @PostMapping(value = "/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String  removeUser(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        userRepository.delete(user);
        return "User removed";

    }
}
