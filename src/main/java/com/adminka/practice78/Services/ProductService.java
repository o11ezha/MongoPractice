package com.adminka.practice78.Services;

import com.adminka.practice78.Models.Product;
import com.adminka.practice78.Repositories.DeleteThingsImplementation;
import com.adminka.practice78.Repositories.ProductRepo;
import com.adminka.practice78.Repositories.SearchMongoRepoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    SearchMongoRepoImplementation searchMongoRepoImplementation;

    @Autowired
    DeleteThingsImplementation deleteThingsImplementation;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(Product prod){
        return productRepo.save(prod);
    }

    public void removeProduct(Integer id){
        deleteThingsImplementation.deleteByProductId(id);
    }
}
