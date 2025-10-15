import java.util.Random;

public class PP1_ExtendFunc {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.displaySpecs();
        car1.start();
        car1.openTrunk();
        car1.playRadio();
        car1.stop();

        Car car2 = new Car("Toyota", "Camry", 2022, "Hybrid", 4, "Hybrid", "Automatic");
        car2.displaySpecs();
        car2.start();
        System.out.println("Vehicle Info: " + car2.getVehicleInfo());
    }
}

class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    private String registrationNumber;
    private boolean isRunning;

    public Vehicle() {
        brand = "Generic";
        model = "Base";
        year = 2000;
        engineType = "Petrol";
        registrationNumber = "REG" + new Random().nextInt(10000);
        isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        registrationNumber = "REG" + new Random().nextInt(10000);
        isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return brand + " " + model + " (" + year + ") - Engine: " + engineType + ", Reg#: " + registrationNumber;
    }

    public void displaySpecs() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Engine: " + engineType);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String reg) {
        registrationNumber = reg;
    }

    public boolean isRunning() {
        return isRunning;
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car() {
        super();
        numberOfDoors = 4;
        fuelType = "Petrol";
        transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    public Car(String brand, String model, int year, String engineType, int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car-specific startup sequence initiated");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Doors: " + numberOfDoors + ", Fuel: " + fuelType + ", Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }
}
