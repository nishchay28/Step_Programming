public class LB3_Overriding {
    public static void main(String[] args) {
        Bird[] birds = { new Eagle(), new Penguin() };
        for (Bird b : birds) {
            b.fly();
        }
    }
}

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguin cannot fly, it swims");
    }
}
