package com.example.webshopbackend.service;

import com.example.webshopbackend.model.Cart;

import java.util.List;

public interface CartService {
    Cart save(Cart cart);
    List<Cart> findAll();
}
