package com.example.webshopbackend.repository;

import com.example.webshopbackend.model.Cart;
import com.example.webshopbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
