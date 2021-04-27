package com.monfauna;

import com.monfauna.dao.SpecieDao;
import com.monfauna.dao.impl.DaoFactory;
import com.monfauna.model.Specie;
import com.monfauna.model.SpecieType;

import java.time.LocalDateTime;
import java.util.List;

public class SpecieTest {
    public static void main(String[] args) {

        //encapsulamento e inversao de controle
        //SpecieDaoImpl specieDao = new SpecieDaoImpl(Database.getConnection());
        //SpecieDao specieDao1 = new SpecieDaoImpl(Database.getConnection());
        SpecieDao specieDao = DaoFactory.getSpecieDao();

        List<Specie> speciesList = specieDao.findAll();
        for (Specie specie : speciesList) {
            System.out.println(specie);
        }

        //Search Specie by id
        System.out.println("");
        System.out.println("search specie by id");
        Specie specie = specieDao.findById(3);
        System.out.println(specie);

        //save specie
        System.out.println("");
        Specie specieToSave = new Specie();
        specieToSave.setScientificName("Gorilla kong");
        specieToSave.setCommonName("King Kong");
        SpecieType specieTypeNew = new SpecieType();
        specieTypeNew.setId(4);
        specieToSave.setSpecieType(specieTypeNew);

        Specie specieSaved = specieDao.save(specieToSave);
        System.out.println("specie saved: " + specieSaved);


        //Update specie
        System.out.println("");
        Specie specieToUpdate = specieDao.findById(specieSaved.getId());
        specieToUpdate.setScientificName("Gozilla kaiju");
        specieToUpdate.setCommonName("Godzilla");
        specieToUpdate.setUpdatedAt(LocalDateTime.now());
        specieToUpdate.setSpecieType(specieTypeNew);
        specieDao.update(specieToUpdate);
        List<Specie> specieList = specieDao.findAll();
        for (Specie s : specieList) {
            System.out.println(s);
        }

        //Remove specie
        System.out.println("");
        specieDao.deleteById(specieSaved.getId());
        Specie specieDeleted = specieDao.findById(specieSaved.getId());
        if (specieDeleted == null) {
            System.out.println("specie removed successfully");
        }

    }
}
