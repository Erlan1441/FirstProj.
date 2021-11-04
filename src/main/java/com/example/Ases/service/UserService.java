package com.example.Ases.service;

import com.example.Ases.model.User;

import java.util.List;

public interface UserService {
    User create (User user);
    User update (User user);
    void delete (Long id);
    List<User> getAllUsers();
    User getUserById(Long id);
}
