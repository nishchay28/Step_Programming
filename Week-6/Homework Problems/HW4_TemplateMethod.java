public class HW4_TemplateMethod {
    public static void main(String[] args) {
        Meal m1 = new PastaMeal();
        m1.prepareMeal();
    }
}

abstract class Meal {
    public final void prepareMeal() {
        boilWater();
        cook();
        serve();
    }

    private void boilWater() {
        System.out.println("Boiling water...");
    }

    protected abstract void cook();

    private void serve() {
        System.out.println("Serving the meal.");
    }
}

class PastaMeal extends Meal {
    @Override
    protected void cook() {
        System.out.println("Cooking pasta with sauce.");
    }
}
