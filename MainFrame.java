package AirLineManagementSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;

public class MainFrame extends JFrame {
    private JTextField txtDeparture, txtDestination, txtDate, txtFlightId, txtPassengerName;
    private JButton btnSearch, btnBook, btnCancel;

    public MainFrame() {
        setTitle("Airline Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize GUI components and add action listeners
        txtDeparture = new JTextField();
        txtDestination = new JTextField();
        txtDate = new JTextField();
        txtFlightId = new JTextField();
        txtPassengerName = new JTextField();

        btnSearch = new JButton("Search Flights");
        btnBook = new JButton("Book Ticket");
        btnCancel = new JButton("Cancel Ticket");

        // Position elements in the frame
        txtDeparture.setBounds(50, 50, 150, 25);
        txtDestination.setBounds(220, 50, 150, 25);
        txtDate.setBounds(390, 50, 150, 25);

        txtFlightId.setBounds(50, 150, 150, 25);
        txtPassengerName.setBounds(220, 150, 150, 25);

        btnSearch.setBounds(50, 100, 150, 30);
        btnBook.setBounds(220, 200, 150, 30);
        btnCancel.setBounds(390, 200, 150, 30);

        // Add components to the frame
        add(txtDeparture);
        add(txtDestination);
        add(txtDate);
        add(txtFlightId);
        add(txtPassengerName);
        add(btnSearch);
        add(btnBook);
        add(btnCancel);

        // Labels for clarity
        JLabel lblFlightId = new JLabel("Flight ID:");
        JLabel lblPassengerName = new JLabel("Passenger Name:");

        lblFlightId.setBounds(50, 130, 150, 20);
        lblPassengerName.setBounds(220, 130, 150, 20);

        add(lblFlightId);
        add(lblPassengerName);

        // Event handling
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String departure = txtDeparture.getText();
                String destination = txtDestination.getText();
                String dateStr = txtDate.getText();

                try {
                    Date date = Date.valueOf(dateStr);
                    ArrayList<Flight> flights = FlightManager.searchFlights(departure, destination, date);
                    if (flights.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No flights found.");
                    } else {
                        flights.forEach(System.out::println); // Display in console or show in GUI
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid date format. Use YYYY-MM-DD.");
                }
            }
        });

        // Book Ticket button action
        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String flightIdStr = txtFlightId.getText();
                String passengerName = txtPassengerName.getText();

                if (flightIdStr.isEmpty() || passengerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
                    return;
                }


                try {
                    // Validate the flight ID input
                    String flightIdInput = txtFlightId.getText().trim();
                    if (flightIdInput.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Flight ID cannot be empty. Please enter a valid number.");
                        return;
                    }

                    int flightId = Integer.parseInt(flightIdInput);
                    System.out.println("Flight ID entered: " + flightId);

                    // Validate the passenger ID input (assuming passengerName is meant to be passenger ID)
                    String passengerNameInput = txtPassengerName.getText().trim();
                    if (passengerName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Passenger Name cannot be empty. Please enter a valid Name.");
                        return;
                    }


                    System.out.println("Passenger Name entered: " + passengerNameInput);

                    // Call the BookingManager to book the ticket
                    boolean success = BookingManager.bookTicket(flightId, passengerName);
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Ticket booked successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Booking failed. Please check the flight ID and passenger ID.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please ensure Flight ID and Passenger ID are valid numbers.");
                    ex.printStackTrace(); // Debugging output for invalid format exceptions
                }
            }
        });

        JTextField txtBookingId = new JTextField();
        txtBookingId.setBounds(50, 250, 150, 25);
        add(txtBookingId);

        JLabel lblBookingId = new JLabel("Booking ID:");
        lblBookingId.setBounds(50, 230, 150, 20);
        add(lblBookingId);

// Cancel Ticket button action
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookingIdInput = txtBookingId.getText().trim();
                if (bookingIdInput.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a Booking ID to cancel.");
                    return;
                }

                try {
                    int bookingId = Integer.parseInt(bookingIdInput);
                    boolean success = BookingManager.cancelTicket(bookingId);
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Ticket canceled successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cancellation failed. Please check the Booking ID.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Booking ID. Please enter a valid number.");
                    ex.printStackTrace();
                }
            }
        });
    }

        public static void main(String[]args){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MainFrame().setVisible(true);
                }
            });
        }
    }

