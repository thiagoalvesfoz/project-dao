package com.monfauna;

import com.monfauna.dao.AnimalDao;
import com.monfauna.dao.impl.DaoFactory;
import com.monfauna.model.Animal;

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

    }
}
