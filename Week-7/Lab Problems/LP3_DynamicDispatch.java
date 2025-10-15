class Character {
    public void attack() {
        System.out.println("Character attacks generically");
    }
}

class Warrior extends Character {
    @Override
    public void attack() {
        System.out.println("Warrior strikes with sword!");
    }
}

class Mage extends Character {
    @Override
    public void attack() {
        System.out.println("Mage casts fireball!");
    }
}

class Archer extends Character {
    @Override
    public void attack() {
        System.out.println("Archer shoots arrow!");
    }
}

public class LP3_DynamicDispatch {
    public static void main(String[] args) {
        Character[] army = {
            new Warrior(),
            new Mage(),
            new Archer()
        };

        for (Character c : army) {
            c.attack();
        }
    }
}
