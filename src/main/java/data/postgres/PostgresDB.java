package data.postgres;

import data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/fitness_club";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

