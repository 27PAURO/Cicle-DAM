package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexioBD {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER = "root";
    private static final String PASSWORD = "pauro";

    public static Connection obtenirConnexio() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
