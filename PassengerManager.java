package AirLineManagementSystem;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerManager {

    public int addPassenger(Passenger passenger) {
        int passengerId = -1;
        try (Connection conn = Database1.getConnection()) {
            String query = "INSERT INTO passengers (name, email, phone) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, passenger.getName());
            ps.setString(2, passenger.getEmail());
            ps.setString(3, passenger.getPhone());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                passengerId = rs.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return passengerId;
    }
}

