public class PP2_GamingControllerConfiguration {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    public PP2_GamingControllerConfiguration() {
        controllerBrand = "GenericPad";
        connectionType = "USB";
        hasVibration = true;
        batteryLevel = 100;
        sensitivity = 1.0;
    }

    public PP2_GamingControllerConfiguration(String controllerBrand, String connectionType, boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        this.batteryLevel = Math.max(0, Math.min(100, batteryLevel));
        this.sensitivity = Math.max(0.1, Math.min(3.0, sensitivity));
    }

    public PP2_GamingControllerConfiguration(String brand, String connectionType) {
        this.controllerBrand = brand;
        this.connectionType = connectionType;
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("Brand: " + controllerBrand);
        System.out.println("Connection: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Enabled" : "Disabled"));
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        PP2_GamingControllerConfiguration gc1 = new PP2_GamingControllerConfiguration();
        PP2_GamingControllerConfiguration gc2 = new PP2_GamingControllerConfiguration("ProPad", "Bluetooth", false, 85, 2.5);
        PP2_GamingControllerConfiguration gc3 = new PP2_GamingControllerConfiguration("QuickPlay", "Wireless");

        gc1.displayConfiguration();
        gc1.calibrateController();
        gc1.testVibration();

        System.out.println();

        gc2.displayConfiguration();
        gc2.calibrateController();
        gc2.testVibration();

        System.out.println();

        gc3.displayConfiguration();
        gc3.calibrateController();
        gc3.testVibration();
    }
}
