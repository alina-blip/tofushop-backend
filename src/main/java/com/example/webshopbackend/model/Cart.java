package com.example.webshopbackend.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private User user;
    @ManyToOne
    private Original original;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String size;

    private int count;
    private LocalDate date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Original getOriginal() {
        return original;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}

