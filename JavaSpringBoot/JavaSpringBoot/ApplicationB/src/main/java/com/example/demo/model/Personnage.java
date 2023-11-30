package com.example.demo.model;

public class Personnage {
    private int id;
    private String nom;
    private int life;
    private String type;

    public Personnage(int id, String nom, int life, String type) {

        this.id = id;

        this.nom = nom;

        this.life = life;

        this.type = type;
    }
    public Personnage() {
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", life=" + life +
                ", type='" + type + '\'' +
                '}';
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
}
