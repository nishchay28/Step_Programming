public class LB6_OverriddenMethods {
    public static void main(String[] args) {
        GiftBox gb = new GiftBox();
        gb.pack();
        gb.unpack();
    }
}

class Box {
    public void pack() {
        System.out.println("Box packed");
    }

    public void unpack() {
        System.out.println("Box unpacked");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack();
        System.out.println("GiftBox decorated with ribbon");
    }

    @Override
    public void unpack() {
        super.unpack();
        System.out.println("GiftBox opened with surprise");
    }
}
