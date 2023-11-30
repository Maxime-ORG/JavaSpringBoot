package com.example.demo.web.controller;

import com.example.demo.model.Personnage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class PersonnageController {
    public PersonnageController(){

    }

    @GetMapping(value = "/random-name")
    public String getRandomName() {
        String url = "https://random-word-api.herokuapp.com/word?lang=en";
        RestTemplate restTemplate = new RestTemplate();
        String[] name = restTemplate.getForObject(url, String[].class);
        return name[0];
    }

    @GetMapping(value = "/random")
    public Personnage getRandomPersonnage() {
        String url = "http://localhost:8081/Personnages";
        RestTemplate restTemplate = new RestTemplate();
        Personnage[] personnages = restTemplate.getForObject(url, Personnage[].class);
        int randIndex = getRandomBetween(0, personnages.length - 1);
        return personnages[randIndex];
    }

    @PostMapping(value = "/random")
    public Personnage createRandomPersonnage() {
        String url = "http://localhost:8081/Personnages";
        RestTemplate restTemplate = new RestTemplate();
        Personnage[] Personnages = restTemplate.getForObject(url, Personnage[].class);

        System.out.println(getMaxId(Personnages));
        Personnage personnage = new Personnage(getMaxId(Personnages)+1, getRandomName(), getRandomBetween(5, 10), getRandType());
        addPersonnageAppliA(personnage);
        return personnage;
    }


    @PostMapping
    private void addPersonnageAppliA(Personnage personnage){
        String url = "http://localhost:8081/Personnage";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(url, personnage);
    }

    private int getRandomBetween(int lower, int upper){
        int r = (int) (Math.random() * (upper - lower)) + lower;
        return r;
    }

    private int getMaxId(Personnage[] personnages){
        Personnage maxIdElement = personnages[0];
        for (Personnage e : personnages) {
            if (e.getId() > maxIdElement.getId()){
                maxIdElement = e;
                System.out.println(e);
            }
        }
        return maxIdElement.getId();
    }

    private String getRandType(){
        ArrayList<String> allType = getAllType();
        int rand = getRandomBetween(0, allType.size());
        return allType.get(rand);
    }

    private ArrayList<String> getAllType(){
        ArrayList<String> allType = new ArrayList<>();
        allType.add("Guerrier");
        allType.add("Magicien");
        return allType;
    }
}
