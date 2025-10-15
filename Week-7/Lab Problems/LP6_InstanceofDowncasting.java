class Device {
    String name;

    public Device(String name) {
        this.name = name;
    }

    public void control() {
        System.out.println("Controlling device: " + name);
    }
}

class SmartClassroom extends Device {
    public SmartClassroom(String name) {
        super(name);
    }

    public void adjustAC() {
        System.out.println(name + ": AC adjusted");
    }
}

class SmartLab extends Device {
    public SmartLab(String name) {
        super(name);
    }

    public void checkSafety() {
        System.out.println(name + ": Safety systems checked");
    }
}

class SmartLibrary extends Device {
    public SmartLibrary(String name) {
        super(name);
    }

    public void trackOccupancy() {
        System.out.println(name + ": Occupancy tracked");
    }
}

public class LP6_InstanceofDowncasting {
    public static void main(String[] args) {
        Device[] devices = {
            new SmartClassroom("Room 101"),
            new SmartLab("Physics Lab"),
            new SmartLibrary("Main Library")
        };

        for (Device d : devices) {
            d.control();
            if (d instanceof SmartClassroom) {
                ((SmartClassroom) d).adjustAC();
            } else if (d instanceof SmartLab) {
                ((SmartLab) d).checkSafety();
            } else if (d instanceof SmartLibrary) {
                ((SmartLibrary) d).trackOccupancy();
            }
        }
    }
}