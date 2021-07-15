package Equipment;

import Hero.PrimaryAttributes;

import java.util.Random;

public class Armor extends Equipment{

    public Armor() {
        super("default", 1, EquipmentSlot.Body, new PrimaryAttributes(0,0,0,0));
    }

    public Armor(ArmorType armorType, int armorRating, EquipmentSlot slot) {
        super("default", 1, EquipmentSlot.Body, new PrimaryAttributes(0,0,0,0));
        this.armorType = armorType;
        ArmorRating = armorRating;
        this.setSlot(slot);
        this.setAttributes(new PrimaryAttributes(0,0,0,0));

    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public int getArmorRating() {
        return ArmorRating;
    }

    public void setArmorRating(int armorRating) {
        ArmorRating = armorRating;
    }

    private ArmorType armorType;
    private int ArmorRating;

    /**
     *  Generates a random name for a armor Item. Can be used instead of making a name yourself
     * @param slot to determine what kind of armor the name should have
     * @return String of the name of the generated name
     */
    public String generateRandomArmorName(EquipmentSlot slot){
        Random rand = new Random();
        String[] descriptions = {"Bloody", "Cool", "Big", "Small", "Pink", "Very very very long", "The eternal", "Hobbit", "Noble", "Heavy", "Cristal", "Mithril", "Light", "Junk" , "Smelly", "Strong", "Shiny"};

        return descriptions[rand.nextInt(descriptions.length)] + " " + slot;
    }


}
