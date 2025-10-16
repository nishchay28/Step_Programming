abstract class Shape {
    protected double area;
    protected double perimeter;

    public abstract void calculateArea();
    public abstract void calculatePerimeter();
}

interface Drawable {
    void draw();
}

class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void calculateArea() {
        area = Math.PI * radius * radius;
    }

    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    public void draw() {
        System.out.println("Drawing a circle");
    }

    public void display() {
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}

public class LP2_AbstractShapeDrawable {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.calculateArea();
        c.calculatePerimeter();
        c.draw();
        c.display();
    }
}
