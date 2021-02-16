package com.example.demo.DAO;

import com.example.demo.Model.Product;

import java.util.HashSet;
import java.util.List;

public interface ProductDAO {
    void insertProduct(Product product);

    HashSet<Product> ShowProducts();

    void DeleteProduct(String name);

    void UpdateProduct(String name, Product product);

    void SaveInFile();


}
