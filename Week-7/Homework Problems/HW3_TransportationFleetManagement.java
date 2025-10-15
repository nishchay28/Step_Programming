class Vehicle {
    public void dispatch() {
        System.out.println("Generic vehicle dispatched");
    }
}

class Bus extends Vehicle {
    @Override
    public void dispatch() {
        System.out.println("Bus dispatched on fixed route with 50 passengers");
    }
}

class Taxi extends Vehicle {
    @Override
    public void dispatch() {
        System.out.println("Taxi dispatched for door-to-door service");
    }
}

class Train extends Vehicle {
    @Override
    public void dispatch() {
        System.out.println("Train dispatched on schedule with 10 cars");
    }
}

class Bike extends Vehicle {
    @Override
    public void dispatch() {
        System.out.println("Bike dispatched for eco-friendly short trip");
    }
}

public class HW3_TransportationFleetManagement {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Bus(),
            new Taxi(),
            new Train(),
            new Bike()
        };

        for (Vehicle v : fleet) {
            v.dispatch();
        }
    }
}
