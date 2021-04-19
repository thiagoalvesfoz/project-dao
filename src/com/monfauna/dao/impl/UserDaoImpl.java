package com.monfauna.dao.impl;

import com.monfauna.dao.UserDao;
import com.monfauna.infra.Database;
import com.monfauna.model.Owner;
import com.monfauna.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final Connection conn;

    public UserDaoImpl(Connection conn){
       this.conn = conn;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findAll()  {

        List<User> users = new ArrayList<>();

        ResultSet rs  = null;

        try{
            String sql = "SELECT * FROM user";
            rs = conn.prepareStatement(sql).executeQuery();

            while (rs.next()){
                User user = getInstanceUser(rs);
                users.add(user);
            }

        } catch (SQLException e){
            System.out.println("Falhou");
            e.printStackTrace();
        } finally {
            Database.closeResultSet(rs);
        }

        return users;

    }

    @Override
    public User findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs  = null;

        try{
            String sql = "SELECT * FROM user WHERE id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()){
                return getInstanceUser(rs);

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
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    private User getInstanceUser(ResultSet rs) throws SQLException {
        User user = new Owner();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setAdmin(rs.getBoolean("admin"));
        return user;
    }
}
