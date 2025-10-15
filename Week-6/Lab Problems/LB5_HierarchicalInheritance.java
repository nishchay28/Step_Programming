public class LB5_HierarchicalInheritance {
    public static void main(String[] args) {
        Instrument[] instruments = {
            new Piano("Piano", "Wood", 88),
            new Guitar("Guitar", "Metal", 6),
            new Drum("Drum", "Plastic", "Bass")
        };

        for (Instrument i : instruments) {
            i.play();
        }
    }
}

class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public void play() {
        System.out.println(name + " made of " + material + " is playing");
    }
}

class Piano extends Instrument {
    private int keys;

    public Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }
}

class Guitar extends Instrument {
    private int strings;

    public Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }
}

class Drum extends Instrument {
    private String type;

    public Drum(String name, String material, String type) {
        super(name, material);
        this.type = type;
    }
}
