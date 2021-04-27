package com.monfauna;

import com.monfauna.dao.SpecieTypeDao;
import com.monfauna.dao.impl.DaoFactory;
import com.monfauna.model.SpecieType;

import java.util.List;

public class SpecieTypeTest {
    public static void main(String[] args) {

        //find all specie types
        SpecieTypeDao specieTypeDao = DaoFactory.getSpecieTypeDao();
        List<SpecieType> specieTypes = specieTypeDao.findAll();
        for (SpecieType st : specieTypes){
            System.out.println(st);
        }

        //find specie type by id
        System.out.println("");
        SpecieType specieTypeSearchById = specieTypeDao.findById(2);
        System.out.println(specieTypeSearchById);

        //save specie type
        System.out.println("");
        SpecieType specieTypeToSave = new SpecieType("Frofalipoda");
        System.out.println("specie type created: " + specieTypeToSave);
        specieTypeToSave = specieTypeDao.save(specieTypeToSave);
        System.out.println("Specie type saved: " + specieTypeToSave);


        //update specie type
        System.out.println("");
        SpecieType specieTypeToUpdate = specieTypeDao.findById(specieTypeToSave.getId());
        specieTypeToUpdate.setName("Farofaliecedonn");
        specieTypeDao.update(specieTypeToUpdate);
        List<SpecieType> specieTypeList = specieTypeDao.findAll();
        for (SpecieType st : specieTypeList) {
            System.out.println(st);
        }

        //delete specie type
        System.out.println("");
        specieTypeDao.deleteById(specieTypeToUpdate.getId());
        SpecieType specieTypeDeleted = specieTypeDao.findById(specieTypeToUpdate.getId());
        if (specieTypeDeleted == null) {
            System.out.println("specie type removed successfully");
        }

    }
}
