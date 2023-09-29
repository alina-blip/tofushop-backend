package com.example.webshopbackend.controller;
import java.util.List;
import java.util.Optional;

import com.example.webshopbackend.model.Original;
import com.example.webshopbackend.service.OriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/original")
public class OriginalController {

    private final OriginalService service;

    @Autowired
    OriginalController(OriginalService service) {
        this.service = service;
    }
    @PostMapping("")
    public Original save(@RequestBody Original original) {
        return service.save(original);
    }

    @GetMapping("")
    public List<Original> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Original> one (@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Original update(@PathVariable long id, @RequestBody Original updatedOriginal) {
        Optional<Original> originalOptional = service.findById(id);
        if (originalOptional.isPresent()) {
            Original original = originalOptional.get();
            original.setDescription(updatedOriginal.getDescription());
            original.setCategory(updatedOriginal.getCategory());
            original.setMaterial(updatedOriginal.getMaterial());
            original.setPrice((float) updatedOriginal.getPrice());
            original.setSize(updatedOriginal.getSize());
            original.setQuantity(updatedOriginal.getQuantity());
            original.setTitle(updatedOriginal.getTitle());
            original.setUrl(updatedOriginal.getUrl());
            return service.save(original);
        } else {
            throw new RuntimeException("Original not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        Optional<Original> originalOptional = service.findById(id);
        if (originalOptional.isPresent()) {
            service.delete(originalOptional.get());
            return ResponseEntity.ok("Deleted successfully"); // Return a 200 OK response
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Original not found with id: " + id);
        }
    }

}
