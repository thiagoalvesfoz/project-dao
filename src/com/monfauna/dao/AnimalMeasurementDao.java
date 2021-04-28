package com.monfauna.dao;

import com.monfauna.model.AnimalMeasurement;

import java.util.List;

public interface AnimalMeasurementDao {
    AnimalMeasurement save(AnimalMeasurement animalMeasurement, Integer animalId);
    List<AnimalMeasurement> findAll();
    AnimalMeasurement findById(Integer id);
    AnimalMeasurement update(AnimalMeasurement entity);
    void deleteById(Integer id);
}
