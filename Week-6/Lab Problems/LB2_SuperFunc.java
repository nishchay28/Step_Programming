public class LB2_SuperFunc {
    public static void main(String[] args) {
        SmartPhone sp1 = new SmartPhone("Apple", "iPhone 14", "iOS");
        SmartPhone sp2 = new SmartPhone("Samsung", "Galaxy S23", "Android");
    }
}

class Phone {
    protected String brand;
    protected String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone constructor: " + brand + " " + model);
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone constructor: OS = " + operatingSystem);
    }
}
