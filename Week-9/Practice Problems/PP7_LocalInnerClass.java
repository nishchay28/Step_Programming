public class PP7_LocalInnerClass {
    void process() {
        class Local {
            void show() {
                System.out.println("Inside local inner class");
            }
        }
        Local l = new Local();
        l.show();
    }

    public static void main(String[] args) {
        new PP7_LocalInnerClass().process();
    }
}
