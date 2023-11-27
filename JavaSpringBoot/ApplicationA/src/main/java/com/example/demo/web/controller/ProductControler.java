package com.example.demo.web.controller;

import com.example.demo.model.Personnage;
import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductControler {
    public ProductControler(){

    }
    

    @GetMapping("/Produits")
    public List<Product> listeProduits() {
        return Product.findAll();
    }

    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return Product.findById(id);
    }

    @PostMapping(value = "/Produits")
    public void ajouterProduit(@RequestBody Product product) {
        Product.save(product);
    }

}