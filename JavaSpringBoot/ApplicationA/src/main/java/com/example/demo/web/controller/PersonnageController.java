package com.example.demo.web.controller;

import com.example.demo.model.Personnage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonnageController {
    public PersonnageController(){

    }

    @GetMapping("/Personnage")
    public List<Personnage> listePersonnage() {
        return Personnage.findAll();
    }

    @GetMapping(value = "/Personnage/{id}")
    public Personnage afficherUnPersonnage(@PathVariable int id) {
        return Personnage.findById(id);
    }

    @GetMapping(value = "/Personnage/type/{type}")
    public List<Personnage> afficherUnPersonnage(@PathVariable String type) {
        return Personnage.findBytype(type);
    }

    @PostMapping(value = "/Personnage")
    public void ajouterPersonnage(@RequestBody Personnage personnage) {
        Personnage.save(personnage);
    }

    @PutMapping(value =  "/Personnage/{id}")
    public void modifierPersonnage(@PathVariable int id, @RequestBody Personnage personnage) {
        Personnage.modify(personnage, id);
    }

    @DeleteMapping(value =  "/Personnage/{id}")
    public void modifierPersonnage(@PathVariable int id) {
        Personnage.delete(id);
    }
}