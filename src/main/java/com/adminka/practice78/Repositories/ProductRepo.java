package com.adminka.practice78.Repositories;

import com.adminka.practice78.Models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepo extends MongoRepository<Product, String> {

}
