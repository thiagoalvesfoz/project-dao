package com.monfauna.infra;

import java.sql.*;

public class Database {

    private static final String username = "root";
    private static final String password = "1234";
    private static final String database = "MonFauna";
    private static final String timeZone = "?useTimezone=true&serverTimezone=UTC";
    private static final String url = "jdbc:mysql://Localhost:3306/" + database + timeZone;
    private static Connection conn = null;

    private Database() {
    }

    public static Connection getConnection() {

        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Conexão bem sucedida");
            } catch (SQLException ex) {
                System.out.println("Falha na conexão!");
                ex.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            System.out.println("não há conexões abertas");
            throwables.printStackTrace();
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            System.out.println("não há conexões abertas");
            throwables.printStackTrace();
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            System.out.println("nao ha conexoes abertas");
            throwables.printStackTrace();
        }
    }
}
