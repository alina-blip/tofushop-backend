package com.example.webshopbackend.service;

import com.example.webshopbackend.model.Original;

import java.util.List;
import java.util.Optional;

public interface OriginalService {
    Original save(Original original);
    List<Original> findAll();
    Optional<Original> findById(Long id);
    void delete(Original original);
}
