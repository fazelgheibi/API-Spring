package com.example.demo.API;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.PATCH;
import java.util.HashSet;

@RequestMapping("/Product")
@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //----------------------------------------Insert Product------------------------------

    @PostMapping
    public void Insert(@RequestBody @Valid @NotNull Product product) {
        this.productService.insertProduct(product);
    }

    //----------------------------------Show All Products----------------------------------

    @GetMapping
    public HashSet<Product> Show() {
        return this.productService.ShowAll();
    }

    //-------------------------------------update Product----------------------------------

    @PutMapping(path = "{name}")
    public void updateProduct(@PathVariable("name") String name, @RequestBody @Valid @NotNull Product product) {
        this.productService.updateProduct(name, product);
    }

    //---------------------------------Delete Product--------------------------------------

    @DeleteMapping(path = "{name}")
    public void DeleteProduct(@PathVariable("name") String name) {
        this.productService.DeleteProduct(name);
    }

    //-----------------------------------------------------------------------------------

}//END Of CLASS
