public class PP6_InstanceofDowncasting {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new Light("Philips Hue", true),
            new Thermostat("Nest", false)
        };

        for (SmartDevice sd : devices) {
            sd.activate();
            if (sd instanceof Light) {
                ((Light) sd).adjustBrightness(75);
            } else if (sd instanceof Thermostat) {
                ((Thermostat) sd).setTemperature(22);
            }
        }
    }
}

class SmartDevice {
    protected String name;
    protected boolean isOnline;

    public SmartDevice(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public void activate() {
        System.out.println(name + " is " + (isOnline ? "online" : "offline"));
    }
}

class Light extends SmartDevice {
    public Light(String name, boolean isOnline) {
        super(name, isOnline);
    }

    public void adjustBrightness(int level) {
        System.out.println(name + " brightness set to " + level + "%");
    }
}

class Thermostat extends SmartDevice {
    public Thermostat(String name, boolean isOnline) {
        super(name, isOnline);
    }

    public void setTemperature(int temp) {
        System.out.println(name + " temperature set to " + temp + "°C");
    }
}
