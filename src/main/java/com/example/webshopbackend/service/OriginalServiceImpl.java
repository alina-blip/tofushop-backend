package com.example.webshopbackend.service;

import com.example.webshopbackend.model.Original;
import com.example.webshopbackend.repository.OriginalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class OriginalServiceImpl implements OriginalService {
    private final OriginalRepository repository;

    @Autowired
    OriginalServiceImpl(OriginalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Original save(Original original) {
        return repository.save(original);
    }

    public List<Original> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Original> findById(Long id) {
        return repository.findById(id);
    }
    @Override
    public void delete(Original original) {
        repository.delete(original);
    }


}
