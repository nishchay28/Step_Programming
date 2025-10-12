abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;

    public MagicalStructure() {
        this("Unknown Structure", 10, "Unknown", true);
    }

    public MagicalStructure(String structureName) {
        this(structureName, 20, "Mystic Land", true);
    }

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    int spellCapacity;
    String[] knownSpells;

    public WizardTower() {
        this("Wizard Tower", 50, "Highlands", true, 5, new String[]{"Fireball", "Shield"});
    }

    public WizardTower(String name, int power, String location, boolean active, int capacity, String[] spells) {
        super(name, power, location, active);
        this.spellCapacity = capacity;
        this.knownSpells = spells;
    }

    public void castMagicSpell() {
        System.out.println("WizardTower casts: " + knownSpells[0]);
    }
}

class EnchantedCastle extends MagicalStructure {
    int defenseRating;
    boolean hasDrawbridge;

    public EnchantedCastle() {
        this("Enchanted Castle", 40, "Valley", true, 100, true);
    }

    public EnchantedCastle(String name, int power, String location, boolean active, int rating, boolean drawbridge) {
        super(name, power, location, active);
        this.defenseRating = rating;
        this.hasDrawbridge = drawbridge;
    }

    public void castMagicSpell() {
        System.out.println("EnchantedCastle activates magical shield!");
    }
}

class MysticLibrary extends MagicalStructure {
    int bookCount;
    String ancientLanguage;

    public MysticLibrary() {
        this("Mystic Library", 30, "Forest", true, 1000, "Elder Tongue");
    }

    public MysticLibrary(String name, int power, String location, boolean active, int books, String language) {
        super(name, power, location, active);
        this.bookCount = books;
        this.ancientLanguage = language;
    }

    public void castMagicSpell() {
        System.out.println("MysticLibrary casts knowledge spell in " + ancientLanguage);
    }
}

class DragonLair extends MagicalStructure {
    String dragonType;
    int treasureValue;

    public DragonLair() {
        this("Dragon Lair", 60, "Mountain", true, "Fire Drake", 10000);
    }

    public DragonLair(String name, int power, String location, boolean active, String type, int treasure) {
        super(name, power, location, active);
        this.dragonType = type;
        this.treasureValue = treasure;
    }

    public void castMagicSpell() {
        System.out.println("DragonLair unleashes dragon fury!");
    }
}

public class LP2_MedievalKingdomBuilder {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return s1.isActive && s2.isActive;
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        return attacker.magicPower > defender.magicPower ? "Attacker wins!" : "Defender holds strong!";
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }

    public static void main(String[] args) {
        MagicalStructure[] kingdom = {
            new WizardTower(),
            new EnchantedCastle(),
            new MysticLibrary(),
            new DragonLair()
        };

        for (MagicalStructure s : kingdom) {
            s.castMagicSpell();
        }

        System.out.println("Total Magic Power: " + calculateKingdomMagicPower(kingdom));
        System.out.println("Battle Result: " + performMagicBattle(kingdom[0], kingdom[1]));
    }
}
