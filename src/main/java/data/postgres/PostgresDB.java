package data.postgres;

import data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {

    private static final String URL = "aws-1-ap-northeast-2.pooler.supabase.com\n" + "\n";
    private static final String USER = "postgres.hmbyvvvvpvebhlabntws" + "\n";
    private static final String PASSWORD = "Baglan08@";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

