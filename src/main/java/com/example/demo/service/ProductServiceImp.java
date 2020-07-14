package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
        @Override
        public List<Product> getAll() {
            return (List<Product>)productRepository.findAll();
        }

        @Override
        public void saveProduct(Product product) {
            productRepository.save(product);
        }

        @Override
        public void deleteProduct(int id) {
            productRepository.deleteById(id);
        }

        @Override
        public Optional<Product> findProductById(int id) {
            return productRepository.findById(id);
        }
}
