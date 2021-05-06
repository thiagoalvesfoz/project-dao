package com.monfauna.dao;

import com.monfauna.model.Animal;
import com.monfauna.model.AnimalMeasurement;

import java.util.List;

public interface AnimalDao {
    Animal save(Animal animal, Integer projectId);
    List<Animal> findAll();
    List<Animal> findAllByProject(Integer idProject);
    Animal findById(Integer id);
    Animal update(Animal entity);
    void deleteById(Integer id);
}
