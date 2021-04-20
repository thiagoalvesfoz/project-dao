package com.monfauna.dao.impl;

import com.monfauna.dao.LocationDao;
import com.monfauna.infra.Database;
import com.monfauna.model.Location;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDaoImpl implements LocationDao {

    private final Connection conn;

    public LocationDaoImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public Location save(Location location) {
        return null;
    }

    @Override
    public List<Location> findAll()  {

        List<Location> locations = new ArrayList<>();

        ResultSet rs  = null;

        try{
            String sql = "SELECT * FROM location";
            rs = conn.prepareStatement(sql).executeQuery();

            while (rs.next()){
                Location location = getInstanceLocation(rs);
                locations.add(location);
            }

        } catch (SQLException e){
            System.out.println("Falhou");
            e.printStackTrace();
        } finally {
            Database.closeResultSet(rs);
        }

        return locations;

    }

    @Override
    public Location findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs  = null;

        try{
            String sql = "SELECT * FROM location WHERE id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()){
                return getInstanceLocation(rs);

            }

        } catch (SQLException e){
            System.out.println("Falhou");
            e.printStackTrace();
        } finally {
            Database.closeResultSet(rs);
        }

        return null;
    }

    @Override
    public Location update(Location location) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    private Location getInstanceLocation(ResultSet rs) throws SQLException {
        Location location = new Location();
        location.setId(rs.getInt("id"));
        location.setName(rs.getString("name"));
        location.setLatitude(rs.getString("latitude"));
        location.setLongitude(rs.getString("longitude"));
        return location;
    }

}
