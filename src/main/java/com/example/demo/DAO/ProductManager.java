package com.example.demo.DAO;

import com.example.demo.FileManager.FileManager;
import com.example.demo.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository("Dao")
public class ProductManager implements ProductDAO {
    private HashSet<Product> list;
    private FileManager fileManager;

    //-------------------------------------Constructor--------------------------

    ProductManager() {
        this.fileManager = new FileManager("Data");
        this.list = this.fileManager.Read();
    }

    //---------------------------------------Insert-----------------------------
    @Override
    public void insertProduct(Product product) {
        if (!this.list.contains(product)) {
            list.add(product);
            this.SaveInFile();
        }
    }


    //----------------------------------------Show------------------------------
    @Override
    public HashSet<Product> ShowProducts() {
        return list;
    }

    //----------------------------------------Delete----------------------------

    @Override
    public void DeleteProduct(String name) {
        this.list.removeIf(product -> product.getName().equals(name));
        this.SaveInFile();
    }

    //----------------------------------------update----------------------------

    @Override
    public void UpdateProduct(String name, Product product) {
        if (!this.list.contains(product)) {
            this.DeleteProduct(name);
            this.list.add(product);
            this.SaveInFile();
        }
    }

    //----------------------------------------Save in File----------------------

    @Override
    public void SaveInFile() {
        this.fileManager.Write(list);
    }

    //--------------------------------------------------------------------------

}// END Of CLASS
