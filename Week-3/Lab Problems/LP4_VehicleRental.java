import java.util.*;

class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private int totalRentalDays;

    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName = "DefaultRentalCo";

    // Constructor
    public Vehicle(String brand, String model, double rent) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rent;
        this.isAvailable = true;
        this.totalRentalDays = 0;
        totalVehicles++;
    }

    // Static method to generate unique vehicle ID
    private static String generateVehicleId() {
        return "VEH" + String.format("%03d", totalVehicles + 1);
    }

    // Instance method to rent vehicle
    public double rentVehicle(int days) {
        if (!isAvailable) {
            System.out.println("Vehicle " + vehicleId + " is not available.");
            return 0;
        }
        double rentAmount = calculateRent(days);
        isAvailable = false;
        totalRentalDays += days;
        System.out.println("Vehicle " + vehicleId + " rented for " + days + " days.");
        return rentAmount;
    }

    // Instance method to return vehicle
    public void returnVehicle() {
        isAvailable = true;
        System.out.println("Vehicle " + vehicleId + " returned.");
    }

    // Instance method to calculate rent
    public double calculateRent(int days) {
        double amount = rentPerDay * days;
        totalRevenue += amount;
        return amount;
    }

    // Instance method to display vehicle info
    public void displayVehicleInfo() {
        System.out.println("ID: " + vehicleId + ", Brand: " + brand + ", Model: " + model);
        System.out.println("Rent/Day: " + rentPerDay + ", Available: " + isAvailable);
        System.out.println("Total Rental Days: " + totalRentalDays);
    }

    // Static methods
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        return totalVehicles == 0 ? 0 : totalRevenue / totalVehicles;
    }

    public static void displayCompanyStats() {
        System.out.println("Company: " + companyName);
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: " + String.format("%.2f", totalRevenue));
        System.out.println("Average Revenue per Vehicle: " + String.format("%.2f", getAverageRentPerDay()));
    }
}

public class LP4_VehicleRental {
    public static void main(String[] args) {
        Vehicle.setCompanyName("ZoomFleet Rentals");

        Vehicle v1 = new Vehicle("Toyota", "Innova", 1500);
        Vehicle v2 = new Vehicle("Honda", "City", 1200);
        Vehicle v3 = new Vehicle("Suzuki", "Swift", 1000);

        v1.displayVehicleInfo();
        System.out.println("Rent Collected: " + v1.rentVehicle(5));
        System.out.println();

        v2.displayVehicleInfo();
        System.out.println("Rent Collected: " + v2.rentVehicle(3));
        System.out.println();

        v1.returnVehicle();
        v1.displayVehicleInfo();
        System.out.println();

        Vehicle.displayCompanyStats();
    }
}