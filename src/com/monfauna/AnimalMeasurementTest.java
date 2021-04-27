package com.monfauna;

import com.monfauna.dao.AnimalMeasurementDao;
import com.monfauna.dao.impl.DaoFactory;
import com.monfauna.model.AnimalMeasurement;
import com.monfauna.model.Owner;
import com.monfauna.model.SpecieType;
import com.monfauna.model.User;

public class AnimalMeasurementTest {
    public static void main(String[] args) {

        AnimalMeasurementDao animalMeasurementDao = DaoFactory.getAnimalMeasurementDao();

        //Save animal measurement
        System.out.println("");
        AnimalMeasurement measurementToSave = new AnimalMeasurement();
        measurementToSave.setLength(8.7);
        measurementToSave.setWidth(8.9);
        measurementToSave.setHeight(8.8);
        measurementToSave.setWeight(8.5);
        measurementToSave.setDescription("default");

        System.out.println("measurement saved= " + measurementToSave);
        measurementToSave = animalMeasurementDao.save(measurementToSave);
        System.out.println("measurement saved= " + measurementToSave);


    }
}
