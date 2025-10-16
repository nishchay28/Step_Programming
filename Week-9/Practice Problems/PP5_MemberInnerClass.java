class Outer {
    private String msg = "Hello from Outer";

    class Inner {
        void show() {
            System.out.println("Inner accessing: " + msg);
        }
    }
}

public class PP5_MemberInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.show();
    }
}
