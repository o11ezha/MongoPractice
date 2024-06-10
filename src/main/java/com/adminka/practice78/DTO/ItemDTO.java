package com.adminka.practice78.DTO;

import com.adminka.practice78.Models.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ItemDTO {
    private Integer itemId;
    private Integer cartId;
    private Integer productId;
    private Integer itemQuantity;
}
