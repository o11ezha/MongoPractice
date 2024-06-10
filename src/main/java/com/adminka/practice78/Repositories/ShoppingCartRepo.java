package com.adminka.practice78.Repositories;

import com.adminka.practice78.Models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, String> {
}
