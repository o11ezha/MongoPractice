package com.adminka.practice78.Models;

import com.mongodb.lang.Nullable;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Field(name = "product_id")
    private Integer productId;

    @Field(name = "product_brand")
    private String productBrand;

    @Field(name = "product_colours")
    @Nullable
    private String productColours;

    @Field(name = "product_feedback")
    @Nullable
    private String productFeedback;

    @Field(name = "product_image")
    @Nullable
    private String productImage;

    @Field(name = "product_layout")
    @Nullable
    private String productLayout;

    @Field(name = "product_name")
    private String productName;

    @Field(name = "product_pretravel")
    @Nullable
    private String productPretravel;

    @Field(name = "product_price")
    private String productPrice;

    @Field(name = "product_size")
    @Nullable
    private String productSize;

    @Field(name = "product_switch")
    @Nullable
    private String productSwitch;

    @Field(name = "product_type")
    private String productType;


}
