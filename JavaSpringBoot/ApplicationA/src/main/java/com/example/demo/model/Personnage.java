package com.example.demo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Personnage {

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
        personnages.add(new Personnage(4, "Soum AKA celle qui fait peur", 350, "Guerrier"));
        personnages.add(new Personnage(1, "Massimo the lazy boy", 350, "Guerrier"));
        personnages.add(new Personnage(3, "Max", 500, "Magicien"));
        personnages.add(new Personnage(2, "Nat le dragon", 750, "Magicien"));
    }
    public static List<Personnage> findAll() {
        return personnages;
    }

    public static Personnage findById(int id) {
        Iterator var2 = personnages.iterator();

        Personnage personnage;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            personnage = (Personnage)var2.next();
        } while(personnage.getId() != id);

        return personnage;
    }

    public static List<Personnage> findBytype(String type) {
        List<Personnage>  copyPersonnages = personnages;
        List<Personnage>  result = copyPersonnages.stream().filter(element -> element.getType().equals(type)).toList();
        return result;
    }

    public static Personnage save(Personnage personnage) {
        personnages.add(personnage);
        return personnage;
    }

    public static void modify(Personnage personnage, int idParam) {
        Optional<Personnage>  result = personnages.stream().filter(element -> element.getId() == idParam).findFirst();
        personnage.setId(idParam);
        if (result.isPresent()) {
            personnages.set(result.get().getId(), personnage);
        }
    }
    public static void delete(int idParam) {
        Optional<Personnage> result = personnages.stream().filter(element -> element.getId() == idParam).findFirst();
        if (result.isPresent()) {
            personnages.remove(result.get().getId());
        }
    }
}
