package AirLineManagementSystem;

import java.sql.*;
import java.util.ArrayList;

public class FlightManager {
    public static ArrayList<Flight> searchFlights(String departure, String destination, Date date) {
        ArrayList<Flight> flights = new ArrayList<>();
        try (Connection conn = Database1.getConnection()) {
            String query = "SELECT * FROM flights WHERE departure = ? AND destination = ? AND date = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, departure);
            ps.setString(2, destination);
            ps.setDate(3, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight(rs.getInt("flight_id"), rs.getString("flight_number"),
                        rs.getString("departure"), rs.getString("destination"),
                        rs.getDate("date"), rs.getTime("time"), rs.getInt("seats_available"));
                flights.add(flight);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flights;
    }
}

