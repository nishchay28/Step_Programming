public class HW2_AccessModifiersInheritance {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Dell", "Inspiron", 8);
        laptop.display();
    }
}

class Computer {
    protected String brand;
    private String model;

    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    protected String getModel() {
        return model;
    }
}

class Laptop extends Computer {
    private int ram;

    public Laptop(String brand, String model, int ram) {
        super(brand, model);
        this.ram = ram;
    }

    public void display() {
        System.out.println("Brand: " + brand + ", Model: " + getModel() + ", RAM: " + ram + "GB");
    }
}
