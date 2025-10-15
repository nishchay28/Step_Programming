public class HW1_LEDConstructor {
    public static void main(String[] args) {
        LED led1 = new LED();
        LED led2 = new LED("Blue", 5);
        led1.display();
        led2.display();
    }
}

class LED {
    private String color;
    private int voltage;

    public LED() {
        color = "Red";
        voltage = 3;
    }

    public LED(String color, int voltage) {
        this.color = color;
        this.voltage = voltage;
    }

    public void display() {
        System.out.println("LED Color: " + color + ", Voltage: " + voltage + "V");
    }
}
