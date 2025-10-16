class Container {
    static class Nested {
        void display() {
            System.out.println("Inside static nested class");
        }
    }
}

public class PP6_StaticNestedClass {
    public static void main(String[] args) {
        Container.Nested nested = new Container.Nested();
        nested.display();
    }
}
