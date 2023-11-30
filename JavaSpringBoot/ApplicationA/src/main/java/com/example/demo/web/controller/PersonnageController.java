package com.example.demo.web.controller;

import com.example.demo.model.Personnage;
import com.example.demo.web.dao.PersonnageDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonnageController {
    private final PersonnageDao personnageDao;

    public PersonnageController(PersonnageDao personnageDao){
        this.personnageDao = personnageDao;
    }

    @GetMapping("/Personnage")
    public List<Personnage> listePersonnage() {
        return personnageDao.findAll();
    }

    @GetMapping(value = "/Personnage/{id}")
    public Personnage afficherUnPersonnage(@PathVariable int id) {
        return personnageDao.findById(id);
    }

    @GetMapping(value = "/Personnage/type/{type}")
    public List<Personnage> afficherUnPersonnage(@PathVariable String type) {
        return personnageDao.findBytype(type);
    }

    @PostMapping(value = "/Personnage")
    public void ajouterPersonnage(@RequestBody Personnage personnage) {
        personnageDao.save(personnage);
    }

    @PutMapping(value =  "/Personnage/{id}")
    public void modifierPersonnage(@PathVariable int id, @RequestBody Personnage personnage) {
        personnageDao.modify(personnage, id);
    }

    @DeleteMapping(value =  "/Personnage/{id}")
    public void modifierPersonnage(@PathVariable int id) {
        personnageDao.delete(id);
    }
}