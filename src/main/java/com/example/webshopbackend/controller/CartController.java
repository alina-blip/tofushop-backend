package com.example.webshopbackend.controller;
import com.example.webshopbackend.model.Cart;
import com.example.webshopbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService service;
    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("")
    public Cart save(@RequestBody Cart cart) {
        return service.save(cart);
    }
    @GetMapping("")
    public List<Cart> all() {
        return service.findAll();
    }
}
