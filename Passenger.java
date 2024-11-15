package AirLineManagementSystem;

public class Passenger {

    private int passengerId;
    private String name;
    private String email;
    private String phone;

    // Constructor
    public Passenger(int passengerId, String name, String email, String phone) {
        this.passengerId = passengerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Overloaded Constructor (without passengerId for new passengers)
    public Passenger(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public int getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

