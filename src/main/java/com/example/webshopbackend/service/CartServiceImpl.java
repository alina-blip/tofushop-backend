package com.example.webshopbackend.service;

import com.example.webshopbackend.model.Cart;
import com.example.webshopbackend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository repository;
@Autowired
    public CartServiceImpl(CartRepository repository) {
        this.repository = repository;
    }
@Override
    public Cart save(Cart cart) {
    return repository.save(cart);
    }
}
