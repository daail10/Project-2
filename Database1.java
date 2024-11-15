package AirLineManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database1 {
    private static final String URL = "jdbc:mysql://localhost:3306/airlinesystem";
    private static final String USER = "root";
    private static final String PASSWORD = "Daail@123";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}