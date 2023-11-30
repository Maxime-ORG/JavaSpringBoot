package com.example.demo.web.dao;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Personnage;
import com.example.demo.web.dao.PersonnageDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;



@Repository
public class PersonnageDaoImpl implements PersonnageDao {


    public static List<Personnage> personnages = new ArrayList();

    static {
        personnages.add(new Personnage(1, "Massimo the lazy boy", 350, "Guerrier"));
        personnages.add(new Personnage(2, "Nat le dragon", 750, "Magicien"));
        personnages.add(new Personnage(3, "Max", 500, "Magicien"));
        personnages.add(new Personnage(4, "Soum AKA celle qui fait peur", 350, "Guerrier"));
    }
    public List<Personnage> findAll() {
        return personnages;
    }

    public Personnage findById(int id) {
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

    public List<Personnage> findBytype(String type) {
        List<Personnage>  copyPersonnages = personnages;
        List<Personnage>  result = copyPersonnages.stream().filter(element -> element.getType().equals(type)).toList();
        return result;
    }

    public Personnage save(Personnage personnage) {
        personnages.add(personnage);
        return personnage;
    }

    public void modify(Personnage personnage, int idParam) {
        Optional<Personnage> result = personnages.stream().filter(element -> element.getId() == idParam).findFirst();
        personnage.setId(idParam);
        if (result.isPresent()) {
            personnages.set(personnages.indexOf(result.get()), personnage);
        }
    }
    public void delete(int idParam) {
        Optional<Personnage> result = personnages.stream().filter(element -> element.getId() == idParam).findFirst();
        if (result.isPresent()) {
            personnages.remove(personnages.indexOf(result.get()));
        }
    }
}