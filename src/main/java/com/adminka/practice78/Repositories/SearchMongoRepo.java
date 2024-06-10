package com.adminka.practice78.Repositories;

import com.adminka.practice78.Models.Product;
import org.springframework.stereotype.Repository;

public interface SearchMongoRepo {

    public Product findByProductId(Integer id);

}
