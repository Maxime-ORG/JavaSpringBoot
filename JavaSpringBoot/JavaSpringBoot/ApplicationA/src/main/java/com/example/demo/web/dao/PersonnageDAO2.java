package com.example.demo.web.dao;

import com.example.demo.model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonnageDAO2 extends JpaRepository<Personnage, Integer> {
    Personnage findById(int id);
}
