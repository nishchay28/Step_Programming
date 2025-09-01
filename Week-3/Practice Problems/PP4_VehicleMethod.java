public class PP4_VehicleMethod {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public PP4_VehicleMethod(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled by " + amount + " liters.");
    }

    public void displayVehicleInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Level: " + fuelLevel + " liters");
    }

    public static void main(String[] args) {
        PP4_VehicleMethod[] vehicles = new PP4_VehicleMethod[3];
        vehicles[0] = new Car("Honda", "Civic", 2020, 30.5);
        vehicles[1] = new Truck("Ford", "F-150", 2018, 50.0);
        vehicles[2] = new Motorcycle("Yamaha", "MT-15", 2022, 15.0);

        for (PP4_VehicleMethod v : vehicles) {
            v.startVehicle();
            v.refuel(10);
            v.displayVehicleInfo();
            v.stopVehicle();
            System.out.println();
        }
    }
}

class Car extends PP4_VehicleMethod {
    public Car(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
}

class Truck extends PP4_VehicleMethod {
    public Truck(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
}

class Motorcycle extends PP4_VehicleMethod {
    public Motorcycle(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
}