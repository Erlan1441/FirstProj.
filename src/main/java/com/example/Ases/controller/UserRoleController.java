package com.example.Ases.controller;

import com.example.Ases.model.User;
import com.example.Ases.model.UserRole;
import com.example.Ases.service.UserRoleService;
import com.example.Ases.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user_role")
public class UserRoleController {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Secured("ROLE_ADMIN")
    @PostMapping("/prectice/user_role")
    private UserRole create(@PathVariable Long id, UserRole userRole){
        userRole.setUser(userService.getUserById(id));
        return userRoleService.create(userRole);
    }
    @Secured("ROLE_ADMIN")
    @PutMapping("/practice/user_role")
    private UserRole update(UserRole userRole){
        return userRoleService.update(userRole);
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/practice/getAll")
    private List<UserRole> getAll(User user){
        return userRoleService.getMyUserRoles(user);

    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/practice/getUSerRole")
    private UserRole getById (@PathVariable Long id){
        return userRoleService.getById(id);
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/practice/deleteRole")
    private void deleteById(@PathVariable Long id ){
        userRoleService.delete(id);
    }
}

