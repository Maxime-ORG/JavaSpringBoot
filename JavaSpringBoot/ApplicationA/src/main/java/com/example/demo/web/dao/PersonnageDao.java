package com.example.demo.web.dao;

import com.example.demo.model.Personnage;

import java.util.List;


public interface PersonnageDao {
    List<Personnage> findAll();
    Personnage findById(int id);
    Personnage save(Personnage product);
    public void delete(int idParam);
    public void modify(Personnage personnage, int idParam);
    public List<Personnage> findBytype(String type);
}