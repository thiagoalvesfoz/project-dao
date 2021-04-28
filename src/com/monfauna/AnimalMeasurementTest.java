package com.monfauna;

import com.monfauna.dao.AnimalMeasurementDao;
import com.monfauna.dao.impl.DaoFactory;
import com.monfauna.model.AnimalMeasurement;
import com.monfauna.model.Owner;
import com.monfauna.model.SpecieType;
import com.monfauna.model.User;

import java.util.List;

public class AnimalMeasurementTest {
    public static void main(String[] args) {

        AnimalMeasurementDao animalMeasurementDao = DaoFactory.getAnimalMeasurementDao();

        //List all measurements
        List<AnimalMeasurement> animalMeasurements = animalMeasurementDao.findAll();
        for (AnimalMeasurement am : animalMeasurements) {
            System.out.println(am);
        }

        //Search measurement by id
        System.out.println("");
        System.out.println("search measurement by id ");
        AnimalMeasurement animalMeasurement = animalMeasurementDao.findById(1);
        System.out.println(animalMeasurement);

       //Save animal measurement
        System.out.println("");
        AnimalMeasurement measurementToSave = new AnimalMeasurement();
        measurementToSave.setLength(8.7);
        measurementToSave.setWidth(8.9);
        measurementToSave.setHeight(8.8);
        measurementToSave.setWeight(8.5);
        measurementToSave.setDescription("default");

        System.out.println("measurement saved= " + measurementToSave);
        measurementToSave = animalMeasurementDao.save(measurementToSave, 3);
        System.out.println("measurement saved= " + measurementToSave);

        //Update measurement
        System.out.println("");
        AnimalMeasurement measurementToUpdate = animalMeasurementDao.findById(measurementToSave.getId());
        measurementToUpdate.setLength(6.4);
        measurementToUpdate.setWidth(4.3);
        measurementToUpdate.setHeight(20.0);
        measurementToUpdate.setWeight(5.2);
        measurementToUpdate.setDescription("skull");
        AnimalMeasurement measurementUpdated = animalMeasurementDao.update(measurementToUpdate);
        System.out.println(measurementUpdated);

        //Remove measurement
        System.out.println("");
        animalMeasurementDao.deleteById(measurementToSave.getId());
        AnimalMeasurement measurementDeleted = animalMeasurementDao.findById(measurementToSave.getId());
        if (measurementDeleted == null) {
            System.out.println("measurement removed successfully");
        }






    }
}
