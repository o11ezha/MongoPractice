package com.adminka.practice78.Controllers;

import com.adminka.practice78.Models.Product;
import com.adminka.practice78.Repositories.SearchMongoRepoImplementation;
import com.adminka.practice78.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SearchMongoRepoImplementation searchMongoRepoImplementation;

    @PreAuthorize("hasAnyAuthority('admin_role', 'user_role', 'manager_role')")
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PreAuthorize("hasAnyAuthority('admin_role', 'manager_role')")
    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product prod){
        return productService.addProduct(prod);
    }

    @PreAuthorize("hasAnyAuthority('admin_role', 'manager_role')")
    @DeleteMapping("/products/delete/{id}")
    public void removeProduct(@PathVariable Integer id){
        productService.removeProduct(id);
    }


}
