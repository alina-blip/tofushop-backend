package com.example.webshopbackend.service;

import com.example.webshopbackend.model.Original;
import com.example.webshopbackend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
    List<User> findAll();
    Optional<User> findById(Long id);
    void delete(User user);
}
