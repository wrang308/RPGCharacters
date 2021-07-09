package Equipment;

public class Armor extends Equipment{

    public Armor() {
    }

    public Armor(ArmorType armorType, int armorRating, EquipmentSlot slot) {
        this.armorType = armorType;
        ArmorRating = armorRating;
        this.slot = slot;

    }

    ArmorType armorType;
    int ArmorRating;


}
