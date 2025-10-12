public class LP1_ProfessionalVirtualPetEvolution {
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;

    private String petName;
    private int age;
    private int happiness;
    private int health;

    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder", "Ghost"};
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    public LP1_ProfessionalVirtualPetEvolution() {
        this("Mystery", PetSpecies.createDefaultSpecies(), 0, 50, 50);
    }

    public LP1_ProfessionalVirtualPetEvolution(String name) {
        this(name, PetSpecies.createDefaultSpecies(), 1, 60, 60);
    }

    public LP1_ProfessionalVirtualPetEvolution(String name, PetSpecies species) {
        this(name, species, 2, 70, 70);
    }

    public LP1_ProfessionalVirtualPetEvolution(String name, PetSpecies species, int age, int happiness, int health) {
        this.petId = generatePetId();
        this.species = species;
        this.birthTimestamp = System.currentTimeMillis();
        setPetName(name);
        setAge(age);
        setHappiness(happiness);
        setHealth(health);
        updateEvolutionStage();
    }

    private String evolutionStage;

    private String generatePetId() {
        return "PET-" + Math.abs(hashCode());
    }

    private void updateEvolutionStage() {
        if (health <= 0) evolutionStage = DEFAULT_EVOLUTION_STAGES[6];
        else if (age < 2) evolutionStage = DEFAULT_EVOLUTION_STAGES[1];
        else if (age < 4) evolutionStage = DEFAULT_EVOLUTION_STAGES[2];
        else if (age < 6) evolutionStage = DEFAULT_EVOLUTION_STAGES[3];
        else if (age < 8) evolutionStage = DEFAULT_EVOLUTION_STAGES[4];
        else evolutionStage = DEFAULT_EVOLUTION_STAGES[5];
    }

    private int validateStat(int stat) {
        return Math.max(0, Math.min(100, stat));
    }

    public void feedPet(String foodType) {
        modifyHappiness(calculateFoodBonus(foodType));
        modifyHealth(5);
    }

    public void playWithPet(String gameType) {
        modifyHappiness(calculateGameEffect(gameType));
        modifyHealth(-5);
    }

    protected int calculateFoodBonus(String foodType) {
        return foodType.equalsIgnoreCase("fruit") ? 10 : 5;
    }

    protected int calculateGameEffect(String gameType) {
        return gameType.equalsIgnoreCase("chase") ? 15 : 8;
    }

    private void modifyHappiness(int delta) {
        happiness = validateStat(happiness + delta);
    }

    private void modifyHealth(int delta) {
        health = validateStat(health + delta);
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String name) {
        this.petName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = Math.max(0, age);
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = validateStat(happiness);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = validateStat(health);
    }

    public String getEvolutionStage() {
        return evolutionStage;
    }

    public String getInternalState() {
        return "PetID: " + petId + ", Species: " + species.getSpeciesName();
    }

    @Override
    public String toString() {
        return petName + " (" + species.getSpeciesName() + ") - Stage: " + evolutionStage;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LP1_ProfessionalVirtualPetEvolution)) return false;
        LP1_ProfessionalVirtualPetEvolution other = (LP1_ProfessionalVirtualPetEvolution) obj;
        return petId.equals(other.petId);
    }

    @Override
    public int hashCode() {
        return petName.hashCode() + species.hashCode();
    }

    public static void main(String[] args) {
        PetSpecies dragon = new PetSpecies("Dragon", new String[]{"Egg", "Hatchling", "Wyrm", "Drake"}, 100, "Mountain");
        LP1_ProfessionalVirtualPetEvolution pet = new LP1_ProfessionalVirtualPetEvolution("Flare", dragon);
        pet.feedPet("fruit");
        pet.playWithPet("chase");
        System.out.println(pet);
    }
}

final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String name, String[] stages, int lifespan, String habitat) {
        if (name == null || stages == null || stages.length == 0 || lifespan <= 0 || habitat == null)
            throw new IllegalArgumentException("Invalid species data");
        this.speciesName = name;
        this.evolutionStages = stages.clone();
        this.maxLifespan = lifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String[] getEvolutionStages() {
        return evolutionStages.clone();
    }

    public int getMaxLifespan() {
        return maxLifespan;
    }

    public String getHabitat() {
        return habitat;
    }

    public static PetSpecies createDefaultSpecies() {
        return new PetSpecies("Phoenix", new String[]{"Egg", "Chick", "Flame", "Rebirth"}, 80, "Sky");
    }
}
