package com.monfauna.dao.impl;

import com.monfauna.dao.SpecieTypeDao;
import com.monfauna.infra.Database;
import com.monfauna.model.SpecieType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecieTypeImpl implements SpecieTypeDao {

    private final Connection conn;

    public SpecieTypeImpl(Connection conn) {
        this.conn = conn;
    }


    @Override
    public SpecieType save(SpecieType user) {
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "";

        return null;
    }

    @Override
    public List<SpecieType> findAll() {

        List<SpecieType> specieTypes = new ArrayList<>();
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM specie_type";
            rs = conn.prepareStatement(sql).executeQuery();

            while (rs.next()) {
                SpecieType specieType = getInstanceSpecieType(rs);
                specieTypes.add(specieType);
            }

        } catch (SQLException e){
            System.out.println("fail");
            e.printStackTrace();

        } finally {
            Database.closeResultSet(rs);
        }

        return specieTypes;
    }



    @Override
    public SpecieType findById(Integer id) {
        return null;
    }

    @Override
    public SpecieType update(SpecieType user) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    private SpecieType getInstanceSpecieType(ResultSet rs) throws SQLException {
        SpecieType specieType = new SpecieType();
        specieType.setId(rs.getInt("id"));
        specieType.setName(rs.getString("name"));

        return specieType;
    }
}
