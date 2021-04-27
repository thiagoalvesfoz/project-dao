package com.monfauna.dao.impl;

import com.monfauna.dao.AnimalMeasurementDao;
import com.monfauna.infra.Database;
import com.monfauna.model.AnimalMeasurement;

import java.sql.*;
import java.util.List;

class AnimalMeasurementDaoImpl implements AnimalMeasurementDao {

    private final Connection conn;

    public AnimalMeasurementDaoImpl(Connection conn) {this.conn = conn; }

    @Override
    public AnimalMeasurement save(AnimalMeasurement animalMeasurement) {

        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "INSERT INTO animal_measurement (length, width, height, weight, description) VALUES (?, ?, ?, ?, ?);";
        try {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, animalMeasurement.getLength());
            ps.setDouble(2, animalMeasurement.getWidth());
            ps.setDouble(3, animalMeasurement.getHeight());
            ps.setDouble(4, animalMeasurement.getWeight());
            ps.setString(5, animalMeasurement.getDescription());

            int rowsAffected = ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if (rowsAffected != 0 && rs.next()) {
                animalMeasurement.setId(rs.getInt(1));
                return animalMeasurement;

            }

        } catch (SQLException e) {
            System.out.println("unable to save data");
            e.printStackTrace();
        } finally {
            Database.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<AnimalMeasurement> findAll() {
        return null;
    }

    @Override
    public AnimalMeasurement findById(Integer id) {
        return null;
    }

    @Override
    public AnimalMeasurement update(AnimalMeasurement entity) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
