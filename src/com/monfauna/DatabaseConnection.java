package com.monfauna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {
        String username = "root";
        String password = "1234";
        String database = "MonFauna";
        String timeZone = "?useTimezone=true&serverTimezone=UTC";
        String url = "jdbc:mysql://Localhost:3306/" + database + timeZone;

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão bem sucedida");
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println("Falha na conexão!");
            ex.printStackTrace();
        }

    }
}
