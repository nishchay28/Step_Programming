abstract class Vehicle {
    public abstract void start();

    public void stop() {
        System.out.println("Vehicle stopped");
    }
}

interface Fuel {
    void refuel();
}

class Car extends Vehicle implements Fuel {
    public void start() {
        System.out.println("Car started");
    }

    public void refuel() {
        System.out.println("Car refueled");
    }
}

public class HW3_VehicleFuelCombo {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.stop();
        c.refuel();
    }
}
