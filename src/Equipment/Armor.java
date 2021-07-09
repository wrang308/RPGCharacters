package Equipment;

import java.util.Random;

public class Armor extends Equipment{

    public Armor() {
    }

    public Armor(ArmorType armorType, int armorRating, EquipmentSlot slot) {
        this.armorType = armorType;
        ArmorRating = armorRating;
        this.slot = slot;

    }

    private ArmorType armorType;
    private int ArmorRating;



    public void generateRandomName(EquipmentSlot slot){
        Random rand = new Random();
        String[] descriptions = {"Bloody", "Cool", "Big", "Small", "Pink", "Very very very long", "The eternal", "Hobbit", "Noble", "Heavy", "Cristal", "Mithril", "Light", "Junk" , "Smelly", "Strong", "Shiny"};

        this.name = descriptions[rand.nextInt(descriptions.length)] + " " + slot;
        System.out.println("ArmorName = " + this.name);
    }


}
