package com.example.Ases.service;

import com.example.Ases.model.User;
import com.example.Ases.model.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole create (UserRole userRole);
    UserRole update (UserRole userRole);
    void delete (Long id);
    List<UserRole> getMyUserRoles(User user);
    UserRole getById (Long id);
}
