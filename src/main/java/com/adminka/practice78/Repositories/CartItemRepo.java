package com.adminka.practice78.Repositories;

import com.adminka.practice78.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
}
