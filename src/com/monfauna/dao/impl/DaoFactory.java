package com.monfauna.dao.impl;

import com.monfauna.infra.Database;
import com.monfauna.model.SpecieType;

public class DaoFactory {
    public static UserDaoImpl getUserDao(){
        return new UserDaoImpl(Database.getConnection());
    }
    public static LocationDaoImpl getLocationDao(){
        return  new LocationDaoImpl(Database.getConnection());
    }
    public static SpecieTypeDaoImpl getSpecieTypeDao(){
        return new SpecieTypeDaoImpl(Database.getConnection());
    }
    public static AnimalMeasurementDaoImpl getAnimalMeasurementDao(){
        return new AnimalMeasurementDaoImpl(Database.getConnection());
    }
    public static SpecieDaoImpl getSpecieDao(){
        return  new SpecieDaoImpl(Database.getConnection());
    }
    public static AnimalDaoImpl getAnimalDao() {
        return  new AnimalDaoImpl(Database.getConnection());
    }
    public static ProjectDaoImpl getProjectDao() {
        return  new ProjectDaoImpl(Database.getConnection());
    }
}
