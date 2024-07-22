package com.kncakal.MaliyetKontrolAPI.controller;

import com.kncakal.MaliyetKontrolAPI.model.Users;
import com.kncakal.MaliyetKontrolAPI.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/users")
    public void save(@RequestBody Users users) throws Exception{
        usersService.save(users);
    }

    @GetMapping("/users")
    public List<Users> get() throws Exception {
        return usersService.findAll();
    }

    @PutMapping("/users")
    public void update(@RequestBody Users users) throws Exception {
        usersService.save(users);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id) throws Exception {
        usersService.delete(id);
    }

    @GetMapping("/user/getById/{id}")
    public Users get(@PathVariable int id) throws Exception {
        Users users = usersService.findById(id);
        return users;
    }
}

