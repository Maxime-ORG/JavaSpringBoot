package com.example.demo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Product {
    private int id;
    private String nom;
    private int prix;

    public Product() {

    }

    public Product(int id, String nom, int prix) {

        this.id = id;

        this.nom = nom;

        this.prix = prix;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }

    public static List<Product> products = new ArrayList();

    static {
        products.add(new Product(1, "Ordinateur portable", 350));
        products.add(new Product(2, "Aspirateur Robot", 500));
        products.add(new Product(3, "Table de Ping Pong", 750));
    }
    public static List<Product> findAll() {
        return products;
    }

    public static Product findById(int id) {
        Iterator var2 = products.iterator();

        Product product;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            product = (Product)var2.next();
        } while(product.getId() != id);

        return product;
    }

    public static Product save(Product product) {
        products.add(product);
        return product;
    }


}

