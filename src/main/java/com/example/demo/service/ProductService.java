package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAll();
    public void saveProduct(Product product);
    public void deleteProduct(int id);
    public Optional<Product> findProductById(int id);
}
