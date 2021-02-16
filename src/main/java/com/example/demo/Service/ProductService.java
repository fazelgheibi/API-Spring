package com.example.demo.Service;

import com.example.demo.DAO.ProductDAO;
import com.example.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ProductService {
    private ProductDAO dao;

    //-------------------------------------Constructor------------------------------

    @Autowired
    public ProductService(@Qualifier("Dao") ProductDAO productDAO) {
        this.dao = productDAO;
    }

    //-------------------------------------Insert--------------------------------

    public void insertProduct(Product product) {
        this.dao.insertProduct(product);
    }

    //--------------------------------------Show---------------------------------

    public HashSet<Product> ShowAll() {
        return this.dao.ShowProducts();
    }

    //--------------------------------------Delete------------------------------

    public void DeleteProduct(String name) {
        this.dao.DeleteProduct(name);
    }

    //------------------------------------update--------------------------------

    public void updateProduct(String name, Product product) {
        this.dao.UpdateProduct(name, product);
    }

    //--------------------------------------------------------------------------

}//END Of CLASS
