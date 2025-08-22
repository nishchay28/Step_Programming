public class Problem1 {
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    public Problem1(String brand,String model, int year, String color,boolean isRunning){
        this.brand = brand;
        this.model =model;
        this.year = year;
        this.color= color;
        this.isRunning = isRunning;
    }

    public void startEngine(){
        isRunning=true;
        System.out.println("Engine Working");
    }

    public void stopEngine(){
        isRunning=false;
        System.out.println("Engine not Working");
    }

    public void disp(){
        System.out.println("Details:\n");
        System.out.println("\nBrand: "+brand+"\nmodel: "+model+"\nYear: "+year+"\ncolor: "+color);
    }

    public void getAge(){
        System.out.println("Car Age: "+ (2025-year));
    }

    public static void main(String[] args) {
        Problem1 c1 = new Problem1("Suzuki", "VDI+" , 2022 , "Black" , true);
        c1.startEngine();
        c1.disp();
        c1.getAge();
        c1.stopEngine();
    }
}
