abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public abstract void startEngine();
}

interface Maintainable {
    void serviceInfo();
}

class Car extends Vehicle implements Maintainable {
    public Car(int speed, String fuelType) {
        super(speed, fuelType);
    }

    public void startEngine() {
        System.out.println("Car engine started at speed: " + speed);
    }

    public void serviceInfo() {
        System.out.println("Service due every 5000 km. Fuel type: " + fuelType);
    }
}

public class LP3_AbstractVehicleMaintainable {
    public static void main(String[] args) {
        Car c = new Car(120, "Petrol");
        c.startEngine();
        c.serviceInfo();
    }
}
