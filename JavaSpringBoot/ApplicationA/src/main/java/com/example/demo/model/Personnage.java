package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFilter;


@Entity
public class Personnage {
    @Id
    private int id;
    private String nom;
    private int life;
    private String type;
    public Personnage() {

    }

    public Personnage(int id, String nom, int life, String type) {

        this.id = id;

        this.nom = nom;

        this.life = life;

        this.type = type;
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", life=" + life + '\'' +
                ", type=" + type +
                '}';
    }

    public static List<Personnage> personnages = new ArrayList();

    static {
        personnages.add(new Personnage(1, "Massimo the lazy boy", 350, "Guerrier"));
        personnages.add(new Personnage(2, "Nat le dragon", 750, "Magicien"));
        personnages.add(new Personnage(3, "Max", 500, "Magicien"));
        personnages.add(new Personnage(4, "Soum AKA celle qui fait peur", 350, "Guerrier"));
    }
}
