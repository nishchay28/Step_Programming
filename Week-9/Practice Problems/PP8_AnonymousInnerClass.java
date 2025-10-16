interface Greeting {
    void sayHello();
}

public class PP8_AnonymousInnerClass {
    public static void main(String[] args) {
        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello from anonymous inner class");
            }
        };
        g.sayHello();
    }
}
