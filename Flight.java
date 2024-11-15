package AirLineManagementSystem;

public class Flight {

    private int flightId;
    private String flightNumber;
    private String departure;
    private String destination;
    private java.sql.Date date;
    private java.sql.Time time;
    private int seatsAvailable;

    // Constructor
    public Flight(int flightId, String flightNumber, String departure, String destination, java.sql.Date date, java.sql.Time time, int seatsAvailable) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.seatsAvailable = seatsAvailable;
    }

    // Getters
    public int getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    // Setters
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightNumber='" + flightNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", seatsAvailable=" + seatsAvailable +
                '}';
    }
}
