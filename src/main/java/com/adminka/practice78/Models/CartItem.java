package com.adminka.practice78.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private ShoppingCart cartId;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "item_quantity")
    private Integer itemQuantity;
}
