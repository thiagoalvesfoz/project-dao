package com.monfauna.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static String username = "root";
    private static String password = "1234";
    private static String database = "MonFauna";
    private static String timeZone = "?useTimezone=true&serverTimezone=UTC";
    private static String url = "jdbc:mysql://Localhost:3306/" + database + timeZone;

    private Database(){
    }

    public static Connection getConnection(){

        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Conexão bem sucedida");
            return conn;
        }
        catch (SQLException ex) {
            System.out.println("Falha na conexão!");
            ex.printStackTrace();
        }
        return null;
    }
    public static void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException throwables) {
            System.out.println("não há conexões abertas");
            throwables.printStackTrace();
        }
    }
}
