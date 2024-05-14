package com.Lexicon.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private static final String JDBC_USER ="root";
    private static final String JDBC_PWD = "6789";
    private static final String JDBC_URL = "jdbc://localhost:3306/todoit";

    public static Connection getConnection() {
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(JDBC_USER, JDBC_PWD, JDBC_URL);

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
