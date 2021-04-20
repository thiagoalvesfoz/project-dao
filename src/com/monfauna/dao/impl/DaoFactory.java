package com.monfauna.dao.impl;

import com.monfauna.infra.Database;

public class DaoFactory {
    public static UserDaoImpl getUserDao(){
        return new UserDaoImpl(Database.getConnection());
    }
    public static LocationDaoImpl getLocationDao(){
        return  new LocationDaoImpl(Database.getConnection());
    }
}
