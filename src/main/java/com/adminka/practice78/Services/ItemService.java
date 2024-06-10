package com.adminka.practice78.Services;

import com.adminka.practice78.DTO.ItemDTO;
import com.adminka.practice78.Models.ShoppingCart;
import com.adminka.practice78.Models.User;
import com.adminka.practice78.Models.CartItem;
import com.adminka.practice78.Repositories.CartItemRepo;
import com.adminka.practice78.Repositories.SearchMongoRepoImplementation;
import com.adminka.practice78.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    CartItemRepo cartItemRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addOrder(ItemDTO itemDTO, String name){
        User user = userRepo.findByUserName(name);
        String sql = "SELECT cart_id FROM shopping_cart WHERE user_id = ?";
        Integer cart_id = jdbcTemplate.queryForObject(sql, Integer.class, user.getUserId());
        itemDTO.setCartId(cart_id);

        String sql2 = "INSERT INTO cart_item (cart_id, product_id, item_quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql2, itemDTO.getCartId(), itemDTO.getProductId(), itemDTO.getItemQuantity());
    }
}
