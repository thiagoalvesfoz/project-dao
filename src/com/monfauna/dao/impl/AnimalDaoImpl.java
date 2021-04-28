package com.monfauna.dao.impl;

import com.monfauna.dao.AnimalDao;
import com.monfauna.infra.Database;
import com.monfauna.model.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalDaoImpl implements AnimalDao {

   private final Connection conn;

   public AnimalDaoImpl(Connection conn) {
       this.conn = conn;
   }


    @Override
    public Animal save(Animal entity) {
        return null;
    }

    @Override
    public List<Animal> findAll() {

        ResultSet rs = null;

       String sql = "select animal.*, \n" +
               "specie.id as specieId, specie.common_name, specie.scientific_name, specie.created_at, specie.updated_at,\n" +
               "specie_type.id as specieTypeId, specie_type.name,\n" +
               "animal_measurement.id as animalMeasurementId, animal_measurement.length, animal_measurement.width,\n" +
               "animal_measurement.height, animal_measurement.weight, animal_measurement.description,  \n" +
               "location.id as locationId, location.name, location.latitude, location.longitude\n" +
               "from animal\n" +
               "left join specie on specie.id = animal.specie_id\n" +
               "left join specie_type on specie_type.id = specie.specie_type_id\n" +
               "left join animal_measurement on animal_measurement.animal_id = animal.id\n" +
               "left join location on location.id = animal.location_id";

       try {

           Map<Integer, Animal> animalMap = new HashMap<>();

           rs = conn.prepareStatement(sql).executeQuery();

           while (rs.next()) {
               Animal animal = animalMap.get(rs.getInt("id"));
               if (animal == null) {
                   //animal = getInstanceAnimal(rs);
               }
           }

       } catch (SQLException e) {


       } finally {
           Database.closeResultSet(rs);
       }


        return null;
    }

    @Override
    public Animal findById(Integer id) {
        return null;
    }

    @Override
    public Animal update(Animal entity) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
