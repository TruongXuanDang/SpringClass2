package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAll();
    public void saveUser(User role);
    public void deleteUser(int id);
    public Optional<User> findUserById(int id);
}
