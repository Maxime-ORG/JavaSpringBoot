package com.example.demo.web.controller;

import com.example.demo.web.dao.PersonnageDAO2 ;
import com.example.demo.model.Personnage ;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import io.swagger.v3.oas.annotations.*;


@RestController
public abstract class PersonnageController {

//    @Autowired

    private PersonnageDAO2 personnageDao;

    public PersonnageController(PersonnageDAO2 personnageDao) {
        this.personnageDao = personnageDao;
    }

    @RequestMapping(value = "/Personnages", method = RequestMethod.GET)

    @Operation(summary = "renvoie la liste complète des personnages")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Personnage trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Personnage non trouvée",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Personnage non accessible",
                    content = @Content) })

    public MappingJacksonValue listeProduits() {

        Iterable<Personnage> personnage = personnageDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("life");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue personnageFiltres = new MappingJacksonValue(personnage);

        personnageFiltres.setFilters(listDeNosFiltres);

        return personnageFiltres;
    }


    @GetMapping(value = "/Personnages/{id}")
    @Operation(summary = "renvoie le personnage avec l'id demandé")

    public Personnage afficherUnProduit(@PathVariable int id)
    {
        return personnageDao.findById(id);
    }

    @DeleteMapping(value =  "/Personnage/{id}")
    @Operation(summary = "supprime le personnage avec l'id demandé")

    public void supprimerPersonnage(@PathVariable int id) {
        personnageDao.deleteById(id);
    }

    @PostMapping("/Personnage")
    @Operation(summary = "ajoute le personnage donné dans le body en Json")

    public void ajouterPersonnage(@RequestBody Personnage personnage) {
        personnageDao.save(personnage);
    }

    @PutMapping("/Personnage/{id}")
    @Operation(summary = "modifie le personnage avec l'id demandé")

    public void modifierPersonnage(@RequestBody Personnage personnage, @PathVariable int id) {
        String nom = personnage.getNom();
        personnageDao.save(personnage);
    }
    
}