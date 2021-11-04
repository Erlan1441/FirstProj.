package com.example.Ases.service;

import com.example.Ases.model.User;
import com.example.Ases.model.UserRole;
import com.example.Ases.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    private User user;

    @Override
    public UserRole create(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole update(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void delete(Long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public List<UserRole> getMyUserRoles(User user) {
        return userRoleRepository.findAll().stream().filter(x ->x.getUser().equals(user)).collect(Collectors.toList());
    }


    @Override
    public UserRole getById(Long id) {
        return userRoleRepository.findById(id).get();
    }


}
