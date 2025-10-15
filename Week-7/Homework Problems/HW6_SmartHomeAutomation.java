class SmartDevice {
    String name;

    public SmartDevice(String name) {
        this.name = name;
    }

    public void control() {
        System.out.println("Controlling " + name);
    }
}

class SmartTV extends SmartDevice {
    public SmartTV(String name) {
        super(name);
    }

    public void streamApp() {
        System.out.println(name + ": Streaming app opened");
    }
}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String name) {
        super(name);
    }

    public void setTemperature(int temp) {
        System.out.println(name + ": Temperature set to " + temp + "°C");
    }
}

class SmartSecurity extends SmartDevice {
    public SmartSecurity(String name) {
        super(name);
    }

    public void activateAlarm() {
        System.out.println(name + ": Alarm activated");
    }
}

class SmartKitchen extends SmartDevice {
    public SmartKitchen(String name) {
        super(name);
    }

    public void startCooking(String recipe) {
        System.out.println(name + ": Cooking " + recipe);
    }
}

public class HW6_SmartHomeAutomation {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartTV("Living Room TV"),
            new SmartThermostat("Nest Thermostat"),
            new SmartSecurity("Front Door Security"),
            new SmartKitchen("Smart Oven")
        };

        for (SmartDevice d : devices) {
            d.control();
            if (d instanceof SmartTV) {
                ((SmartTV) d).streamApp();
            } else if (d instanceof SmartThermostat) {
                ((SmartThermostat) d).setTemperature(22);
            } else if (d instanceof SmartSecurity) {
                ((SmartSecurity) d).activateAlarm();
            } else if (d instanceof SmartKitchen) {
                ((SmartKitchen) d).startCooking("Lasagna");
            }
        }
    }
}
