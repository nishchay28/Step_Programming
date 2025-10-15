public class PP2_MultiLevelInheritance {
    public static void main(String[] args) {
        Dog dog = new Dog("Canine", "Domestic", 13, false, "Short", true, "Beagle", "Woof!");
        dog.eat();
        dog.sleep();
        dog.walk();
        dog.bark();
    }
}

class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Mammal extends Animal {
    protected String furType;
    protected boolean isDomesticated;

    public Mammal(String species, String habitat, int lifespan, boolean isWildlife, String furType, boolean isDomesticated) {
        super(species, habitat, lifespan, isWildlife);
        this.furType = furType;
        this.isDomesticated = isDomesticated;
        System.out.println("Mammal constructor: Creating " + species);
    }

    public void walk() {
        System.out.println("Mammal is walking");
    }
}

class Dog extends Mammal {
    private String breed;
    private String sound;

    public Dog(String species, String habitat, int lifespan, boolean isWildlife, String furType, boolean isDomesticated, String breed, String sound) {
        super(species, habitat, lifespan, isWildlife, furType, isDomesticated);
        this.breed = breed;
        this.sound = sound;
        System.out.println("Dog constructor: Creating " + breed);
    }

    public void bark() {
        System.out.println("Dog says: " + sound);
    }
}
