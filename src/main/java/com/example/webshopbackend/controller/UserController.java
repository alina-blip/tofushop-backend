package com.example.webshopbackend.controller;
import com.example.webshopbackend.model.Original;
import com.example.webshopbackend.model.User;
import com.example.webshopbackend.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    UserController(UserService service) {
        this.service = service;
    }
    @GetMapping("")
    public List<User> all() {
        return service.findAll();
    }

    @PostMapping("")
    public User save(@RequestBody User user) {
        return service.save(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existingUser = service.findByEmail(user.getEmail());
        if (existingUser != null) {
            // Compare the provided login password with the stored hashed password
            if (BCrypt.checkpw(user.getPassword(), existingUser.getPassword())) {
                return ResponseEntity.ok("{\"message\": \"Login successful\"}");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid credentials\"}");
    }

    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody User updatedUser) {
        Optional<User> userOptional = service.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(updatedUser.getName());
            user.setSurname(updatedUser.getSurname());
            user.setStreet(updatedUser.getStreet());
            user.setHousenumber(updatedUser.getHousenumber());
            user.setPostalcode(updatedUser.getPostalcode());
            user.setCountry(updatedUser.getCountry());
            user.setEmail(updatedUser.getEmail());
            user.setRole(updatedUser.getRole());
            user.setPassword(updatedUser.getPassword());
            return service.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        Optional<User> userOptional = service.findById(id);
        if (userOptional.isPresent()) {
            service.delete(userOptional.get());
            return ResponseEntity.ok("User deleted successfully"); // Return a 200 OK response
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
    }

}
