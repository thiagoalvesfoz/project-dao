package com.monfauna.dao.impl;

import com.monfauna.dao.AnimalDao;
import com.monfauna.infra.Database;
import com.monfauna.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.format.DateTimeFormatter.ofPattern;

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

       String sql = "select animal.*, " +
               "specie.id as specieId, specie.common_name, specie.scientific_name, " +
               "specie.created_at as specieCreatedAt, specie.updated_at as specieUpdatedAt," +
               "specie_type.id as specieTypeId, specie_type.name as specieTypeName, " +
               "animal_measurement.id as animalMeasurementId, animal_measurement.length, animal_measurement.width, " +
               "animal_measurement.height, animal_measurement.weight, animal_measurement.description,  " +
               "location.id as locationId, location.name as locationName, location.latitude, location.longitude " +
               "from animal " +
               "left join specie on specie.id = animal.specie_id " +
               "left join specie_type on specie_type.id = specie.specie_type_id " +
               "left join animal_measurement on animal_measurement.animal_id = animal.id " +
               "left join location on location.id = animal.location_id";

       try {

           Map<Integer, Animal> animalMap = new HashMap<>();

           rs = conn.prepareStatement(sql).executeQuery();

           while (rs.next()) {
               int animalId = rs.getInt("id");
               Animal animal = animalMap.get(animalId);

               if (animal == null) {
                   animal = getInstanceAnimal(rs);
                   animal.setSpecie(getInstanceSpecie(rs));
                   animal.getSpecie().setSpecieType(getInstanceSpecieType(rs));
                   animal.setLocation(getInstanceLocation(rs));
               }
               // add animalMeasurements into list
               animal.getMeasurements().add(getInstanceAnimalMeasurement(rs));
               //add animal instance on animalMap
               animalMap.put(animalId, animal);
           }
           //convert animalMap into list and return list
           return new ArrayList<>(animalMap.values());

       } catch (SQLException e) {
           System.out.println("fail");
           e.printStackTrace();
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

    private Animal getInstanceAnimal(ResultSet rs) throws SQLException {
       Animal animal = new Animal();
       animal.setId(rs.getInt("id"));
       animal.setNumber(rs.getString("number"));
       animal.setSex(rs.getString("sex").charAt(0));
       animal.setImageUrl(rs.getString("image"));
       animal.setCreatedAt(rs.getDate("created_at").toLocalDate().atStartOfDay());
       animal.setUpdatedAt(rs.getDate("updated_at").toLocalDate().atStartOfDay());
       animal.setRegisterDate(rs.getDate("register_date").toLocalDate());
       return animal;
    }

    private Specie getInstanceSpecie(ResultSet rs) throws SQLException {
        Specie specie = new Specie();
        specie.setId(rs.getInt("specieId"));
        specie.setScientificName(rs.getString("scientific_name"));
        specie.setCommonName(rs.getString("common_name"));
        specie.setCreatedAt(rs.getDate("specieCreatedAt").toLocalDate().atStartOfDay());
        specie.setUpdatedAt(rs.getDate("specieUpdatedAt").toLocalDate().atStartOfDay());
        return specie;
    }

    private SpecieType getInstanceSpecieType(ResultSet rs) throws SQLException {
       SpecieType specieType = new SpecieType();
       specieType.setId(rs.getInt("specieTypeId"));
       specieType.setName(rs.getString("specieTypeName"));
       return specieType;
    }

    private Location getInstanceLocation(ResultSet rs) throws SQLException {
        Location location = new Location();
        location.setId(rs.getInt("locationId"));
        location.setName(rs.getString("locationName"));
        location.setLatitude(rs.getString("latitude"));
        location.setLongitude(rs.getString("longitude"));
        return location;
    }

    private AnimalMeasurement getInstanceAnimalMeasurement(ResultSet rs) throws SQLException {
       AnimalMeasurement animalMeasurement = new AnimalMeasurement();
       animalMeasurement.setId(rs.getInt("animalMeasurementId"));
       animalMeasurement.setLength(rs.getDouble("length"));
       animalMeasurement.setWidth(rs.getDouble("width"));
       animalMeasurement.setHeight(rs.getDouble("height"));
       animalMeasurement.setWeight(rs.getDouble("weight"));
       animalMeasurement.setDescription(rs.getString("description"));
       return animalMeasurement;
    }

}
