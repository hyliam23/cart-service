package com.example.cartservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private List<CartItem> cart = new ArrayList<>();
    private Long currentId = 1L;

    @GetMapping
    public List<CartItem> viewCart() {
        return cart;
    }

    @PostMapping
    public CartItem addItem(@RequestBody CartItem newItem) {
        newItem.setId(currentId++);
        cart.add(newItem);
        return newItem;
    }

    @DeleteMapping("/{id}")
    public String removeItem(@PathVariable Long id) {
        cart.removeIf(item -> item.getId().equals(id));
        return "Item removed";
    }
}
