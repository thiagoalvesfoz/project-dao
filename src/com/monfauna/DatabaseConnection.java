package com.monfauna;

import com.monfauna.infra.Database;
import com.monfauna.model.Owner;

import java.sql.*;

public class DatabaseConnection {

    public static void main(String[] args) {

        Connection conn = Database.getConnection();

        try{
            String sql = "SELECT * FROM user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();

            while (rs.next()){
                Owner user = new Owner();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("admin"));
                System.out.println(user);
            }

            rs.close();
            ps.close();
        }catch (SQLException e){
            System.out.println("Falhou");
            e.printStackTrace();
        }

        Database.closeConnection(conn);

    }
}
