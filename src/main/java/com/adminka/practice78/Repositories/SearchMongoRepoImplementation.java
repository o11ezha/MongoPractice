package com.adminka.practice78.Repositories;

import com.adminka.practice78.Models.Product;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class SearchMongoRepoImplementation implements SearchMongoRepo {

    @Autowired
    MongoClient mongoClient;

    @Override
    public Product findByProductId(Integer id) {
        final Product product = new Product();

        Bson filter = new Document("product_id", id);

        MongoDatabase database = mongoClient.getDatabase("keyboardshop");
        MongoCollection<Document> collection = database.getCollection("products");
        FindIterable<Document> result = collection.find(filter);



        for (Document document : result) {
            product.setProductId(document.getInteger("product_id"));
            product.setProductColours(document.getString("product_colours"));
            product.setProductFeedback(document.getString("product_feedback"));
            product.setProductBrand(document.getString("product_brand"));
            product.setProductImage(document.getString("product_image"));
            product.setProductLayout(document.getString("product_layout"));
            product.setProductName(document.getString("product_name"));
            product.setProductPretravel(document.getString("product_pretravel"));
            product.setProductPrice(document.getString("product_price"));
            product.setProductSize(document.getString("product_size"));
            product.setProductSwitch(document.getString("product_switch"));
            product.setProductType(document.getString("product_type"));
        }

        System.out.println(product);
        return product;
    }




}
