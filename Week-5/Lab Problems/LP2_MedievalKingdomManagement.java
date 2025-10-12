import java.util.*;

final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final Map<String, Integer> resourceLimits;

    public KingdomConfig(String name, int year, String[] types, Map<String, Integer> limits) {
        if (name == null || year <= 0 || types == null || limits == null)
            throw new IllegalArgumentException("Invalid config");
        this.kingdomName = name;
        this.foundingYear = year;
        this.allowedStructureTypes = types.clone();
        this.resourceLimits = new HashMap<>(limits);
    }

    public String getKingdomName() {
        return kingdomName;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public String[] getAllowedStructureTypes() {
        return allowedStructureTypes.clone();
    }

    public Map<String, Integer> getResourceLimits() {
        return new HashMap<>(resourceLimits);
    }

    public static KingdomConfig createDefaultKingdom() {
        return new KingdomConfig("Avalon", 1200, new String[]{"Tower", "Castle", "Library", "Lair"},
                Map.of("Mana", 5000, "Gold", 10000));
    }
}

class MagicalStructure {
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName;
    private final String location;

    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;

    static final int MIN_MAGIC_POWER = 0;
    static final int MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "3.0";

    public MagicalStructure(String name, String location) {
        this(name, location, 100, true);
    }

    public MagicalStructure(String name, String location, int power) {
        this(name, location, power, true);
    }

    public MagicalStructure(String name, String location, int power, boolean active) {
        this.structureId = UUID.randomUUID().toString();
        this.constructionTimestamp = System.currentTimeMillis();
        this.structureName = name;
        this.location = location;
        this.magicPower = Math.max(MIN_MAGIC_POWER, Math.min(MAX_MAGIC_POWER, power));
        this.isActive = active;
        this.currentMaintainer = "Unknown";
    }

    public void displayStructure() {
        System.out.println("Structure: " + structureName + " | Location: " + location + " | Power: " + magicPower);
    }
}

public class LP2_MedievalKingdomManagement {
    public static void main(String[] args) {
        KingdomConfig config = KingdomConfig.createDefaultKingdom();
        MagicalStructure tower = new MagicalStructure("Wizard Tower", "North Hill", 300);
        MagicalStructure castle = new MagicalStructure("Enchanted Castle", "Valley", 500);

        tower.displayStructure();
        castle.displayStructure();

        System.out.println("Kingdom: " + config.getKingdomName() + " (" + config.getFoundingYear() + ")");
    }
}
