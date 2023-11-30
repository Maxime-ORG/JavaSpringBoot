package com.example.demo.web.controller;

import com.example.demo.web.dao.PersonnageDAO2 ;
import com.example.demo.model.Personnage ;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class PersonnageController {

    @Autowired

    private PersonnageDAO2 personnageDao;

    //Récupérer la liste des produits
    @RequestMapping(value = "/Personnages", method = RequestMethod.GET)

    public MappingJacksonValue listeProduits() {

        Iterable<Personnage> personnage = personnageDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("life");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue personnageFiltres = new MappingJacksonValue(personnage);

        personnageFiltres.setFilters(listDeNosFiltres);

        return personnageFiltres;
    }


    @GetMapping(value = "/Personnages/{id}")

    public Personnage afficherUnProduit(@PathVariable int id)
    {
        return personnageDao.findById(id);
    }

    @DeleteMapping(value =  "/Personnage/{id}")
    public void supprimerPersonnage(@PathVariable int id) {
        personnageDao.deleteById(id);
    }

    @PutMapping("/Personnage")
    public void listePersonnage(@RequestBody Personnage personnage) {
        personnageDao.save(personnage);
    }
}