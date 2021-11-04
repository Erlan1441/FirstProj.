package com.example.Ases.controller;

import com.example.Ases.model.User;
import com.example.Ases.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create (@RequestBody User user){
        return userService.create(user);
    }
    @PutMapping("/update")
    public User update (@RequestBody User user){
        return userService.update(user);
    }
    @GetMapping("/getAll")
    public List<User> getAll(){
        return  userService.getAllUsers();
    }
    @GetMapping("/getUser/{id}")
    public  User getById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @DeleteMapping("delete")
    public void delete (@PathVariable Long id){
        userService.delete(id);
    }
}