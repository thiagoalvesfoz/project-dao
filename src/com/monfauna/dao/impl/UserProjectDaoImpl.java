package com.monfauna.dao.impl;

import com.monfauna.dao.UserProjectDao;
import com.monfauna.infra.Database;
import com.monfauna.model.UserProject;

import java.sql.*;
import java.util.List;

class UserProjectDaoImpl implements UserProjectDao {

    private final Connection conn;

    UserProjectDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public UserProject save(UserProject userProject) {

        PreparedStatement ps = null;

        String sql = "INSERT INTO user_project (project_id, user_id, role) VALUES (?, ?, ?);";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userProject.getProjectId());
            ps.setInt(2, userProject.getUserId());
            ps.setString(3, userProject.getRole());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("unable to save user project");
            }

        } catch (SQLException e) {
            System.out.println("unable to save data");
            e.printStackTrace();
        } finally {
            Database.closePreparedStatement(ps);
        }
        return null;
    }

    @Override
    public List<UserProject> findAll() {
        return null;
    }

    @Override
    public UserProject findById(Integer id) {
        return null;
    }

    @Override
    public UserProject update(UserProject entity) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
