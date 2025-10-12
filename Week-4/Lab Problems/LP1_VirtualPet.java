import java.util.*;

public class LP1_VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String evolutionStage;
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder", "Ghost"};
    private static int totalPetsCreated = 0;

    public LP1_VirtualPet() {
        this("Mystery", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    public LP1_VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }

    public LP1_VirtualPet(String petName, String species) {
        this(petName, species, 2, 70, 70, EVOLUTION_STAGES[2]);
    }

    public LP1_VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.evolutionStage = stage;
        totalPetsCreated++;
    }

    public static String generatePetId() {
        return "PET-" + UUID.randomUUID().toString().substring(0, 8);
    }

    private static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Unicorn", "Griffin", "Chimera"};
        return speciesList[new Random().nextInt(speciesList.length)];
    }

    public void feedPet() {
        happiness += 10;
        health += 5;
    }

    public void playWithPet() {
        happiness += 15;
        health -= 5;
    }

    public void healPet() {
        health += 20;
    }

    public void simulateDay() {
        age++;
        happiness -= new Random().nextInt(10);
        health -= new Random().nextInt(10);
        evolvePet();
    }

    public void evolvePet() {
        if (health <= 0) {
            evolutionStage = EVOLUTION_STAGES[6];
        } else if (age < 2) {
            evolutionStage = EVOLUTION_STAGES[1];
        } else if (age < 4) {
            evolutionStage = EVOLUTION_STAGES[2];
        } else if (age < 6) {
            evolutionStage = EVOLUTION_STAGES[3];
        } else if (age < 8) {
            evolutionStage = EVOLUTION_STAGES[4];
        } else {
            evolutionStage = EVOLUTION_STAGES[5];
        }
    }

    public String getPetStatus() {
        return evolutionStage;
    }

    public void displayPet() {
        System.out.printf("🐾 %s (%s) | Age: %d | Happiness: %d | Health: %d | Stage: %s%n",
                petName, species, age, happiness, health, evolutionStage);
    }

    public static void main(String[] args) {
        LP1_VirtualPet pet1 = new LP1_VirtualPet("Fluffy", "Dragon");
        LP1_VirtualPet pet2 = new LP1_VirtualPet();

        for (int i = 0; i < 5; i++) {
            pet1.simulateDay();
            pet2.simulateDay();
        }

        pet1.displayPet();
        pet2.displayPet();
    }
}
