package AirLineManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

    public class BookingManager {

            public static boolean bookTicket(int flightId, String passengerName) {
                try (Connection conn = Database1.getConnection()) {
                    // Check if the flight ID exists
                    String checkFlightQuery = "SELECT COUNT(*) FROM flights WHERE flight_id = ?";
                    PreparedStatement checkPs = conn.prepareStatement(checkFlightQuery);
                    checkPs.setInt(1, flightId);
                    ResultSet rs = checkPs.executeQuery();
                    if (rs.next() && rs.getInt(1) == 0) {
                        System.err.println("Invalid flight ID: " + flightId);
                        return false; // Flight ID does not exist
                    }

                    // Proceed with booking if the flight ID is valid
                    String query = "INSERT INTO bookings (flight_id, passenger_name, booking_date, status) VALUES (?, ?, CURDATE(), 'Booked')";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setInt(1, flightId);
                    ps.setString(2, passengerName);
                    ps.executeUpdate();
                    return true;
                } catch (SQLException | ClassNotFoundException e) {
                    // Log the error for better debugging
                    System.err.println("Booking failed: " + e.getMessage());
                    e.printStackTrace();
                    return false;
                }
            }

        public static boolean cancelTicket(int bookingId) {
            try (Connection conn = Database1.getConnection()) {
                // Option 1: Delete the booking from the table
                String deleteQuery = "DELETE FROM bookings WHERE booking_id = ?";
                PreparedStatement ps = conn.prepareStatement(deleteQuery);
                ps.setInt(1, bookingId);
                int rowsAffected = ps.executeUpdate();

                // Option 2 (alternative): Update the booking status to "Cancelled"
                // String updateQuery = "UPDATE bookings SET status = 'Cancelled' WHERE booking_id = ?";
                // PreparedStatement ps = conn.prepareStatement(updateQuery);
                // ps.setInt(1, bookingId);
                // int rowsAffected = ps.executeUpdate();

                return rowsAffected > 0;
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
    }



