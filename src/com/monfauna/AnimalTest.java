package com.monfauna;

import com.monfauna.dao.AnimalDao;
import com.monfauna.dao.impl.DaoFactory;
import com.monfauna.model.Animal;
import com.monfauna.model.Location;
import com.monfauna.model.Specie;

import java.time.LocalDate;
import java.util.List;

public class AnimalTest {
    public static void main(String[] args) {

        AnimalDao animalDao = DaoFactory.getAnimalDao();

        //List all animals
        System.out.println("search all animals");
        List<Animal> animalList = animalDao.findAll();
        for (Animal a : animalList) {
            System.out.println(a);
        }

        //Find animal by id
        System.out.println("");
        System.out.println("search animal by id ");
        Animal animal = animalDao.findById(3);
        System.out.println(animal);


        //Save animal
        System.out.println("");
        Animal animalToSave = new Animal();
        Specie specieNew = new Specie();
        specieNew.setId(2);
        animalToSave.setSpecie(specieNew);
        animalToSave.setTag("2346");
        animalToSave.setSex('M');
        animalToSave.setImageUrl("aefvjuyikyu54e4236ukjgf");
        animalToSave.setRegisterDate(LocalDate.now());
        Location locationNew = new Location();
        locationNew.setId(1);
        animalToSave.setLocation(locationNew);
        System.out.println(animalToSave);
        Animal animalSaved = animalDao.save(animalToSave, 2);
        System.out.println(animalSaved);


        //Update animal
        System.out.println("");
        Animal animalToUpdate = animalDao.findById(animalSaved.getId());
        animalToUpdate.setTag("27746");
        animalToUpdate.setSex('F');
        animalToUpdate.setImageUrl("aefvjuyikyu54e4236ukjgf");
        animalToUpdate.setRegisterDate(LocalDate.now());
        animalDao.update(animalToUpdate);
        List<Animal> animals = animalDao.findAll();
        for (Animal a : animals) {
            System.out.println(a);
        }

        //Delete animal by id
        System.out.println("");
        animalDao.deleteById(animalSaved.getId());
        Animal animalDeleted = animalDao.findById(animalSaved.getId());
        if (animalDeleted == null) {
            System.out.println("animal removed successfully");
        }


    }

}
