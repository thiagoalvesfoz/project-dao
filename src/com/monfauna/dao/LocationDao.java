package com.monfauna.dao;

import com.monfauna.model.Location;

import java.util.List;

public interface LocationDao {

    Location save( Location location);
    List<Location> findAll();
    Location findById(Integer id);
    Location update(Location location);
    void deleteById(Integer id);
}
