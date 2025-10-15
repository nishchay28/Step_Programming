public class LB1_SingleInheritance {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.color = "Red";
        apple.taste = "Sweet";
        apple.variety = "Fuji";
        System.out.println("Color: " + apple.color);
        System.out.println("Taste: " + apple.taste);
        System.out.println("Variety: " + apple.variety);
    }
}

class Fruit {
    protected String color;
    protected String taste;
}

class Apple extends Fruit {
    protected String variety;
}
