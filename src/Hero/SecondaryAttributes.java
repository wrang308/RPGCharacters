package Hero;

public class SecondaryAttributes {

    public SecondaryAttributes(int health, int armorRating, int elementalResistance) {
        Health = health;
        ArmorRating = armorRating;
        ElementalResistance = elementalResistance;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getArmorRating() {
        return ArmorRating;
    }

    public void setArmorRating(int armorRating) {
        ArmorRating = armorRating;
    }

    public int getElementalResistance() {
        return ElementalResistance;
    }

    public void setElementalResistance(int elementalResistance) {
        ElementalResistance = elementalResistance;
    }

    private int Health;
    private int ArmorRating;
    private int ElementalResistance;

}
