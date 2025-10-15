public class HW6_CompleteInheritanceImplementation {
    public static void main(String[] args) {
        Thunderstorm ts = new Thunderstorm("Heavy Thunderstorm", 85, true);
        Sunshine sun = new Sunshine("Bright Day", 95, false);

        Weather[] forecasts = { ts, sun };
        for (Weather w : forecasts) {
            w.display();
            w.predict();
            System.out.println();
        }
    }
}

class Weather {
    protected String type;
    protected int intensity;
    protected boolean isSevere;

    public Weather(String type, int intensity, boolean isSevere) {
        this.type = type;
        this.intensity = intensity;
        this.isSevere = isSevere;
        System.out.println("Weather constructor: " + type);
    }

    public void display() {
        System.out.println("Type: " + type + ", Intensity: " + intensity + ", Severe: " + isSevere);
    }

    public void predict() {
        System.out.println("General weather prediction");
    }
}

class Storm extends Weather {
    public Storm(String type, int intensity, boolean isSevere) {
        super(type, intensity, isSevere);
        System.out.println("Storm constructor");
    }

    @Override
    public void predict() {
        System.out.println("Storm warning issued");
    }
}

class Thunderstorm extends Storm {
    public Thunderstorm(String type, int intensity, boolean isSevere) {
        super(type, intensity, isSevere);
        System.out.println("Thunderstorm constructor");
    }

    @Override
    public void predict() {
        System.out.println("Thunderstorm alert: Stay indoors");
    }
}

class Sunshine extends Weather {
    public Sunshine(String type, int intensity, boolean isSevere) {
        super(type, intensity, isSevere);
        System.out.println("Sunshine constructor");
    }

    @Override
    public void predict() {
        System.out.println("Sunny day ahead");
    }
}
