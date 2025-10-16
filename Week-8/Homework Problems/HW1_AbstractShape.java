abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    public void displayInfo() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}

public class HW1_AbstractShape {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        s1.displayInfo();
        System.out.println("Area: " + s1.area());
        System.out.println("Perimeter: " + s1.perimeter());

        Shape s2 = new Rectangle(4, 6);
        s2.displayInfo();
        System.out.println("Area: " + s2.area());
        System.out.println("Perimeter: " + s2.perimeter());
    }
}
