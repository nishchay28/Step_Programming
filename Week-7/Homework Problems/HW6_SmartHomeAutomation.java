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
        System.out.println(name + ": Temperature set to " + temp);
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

    public