package Equipment;

import java.util.Random;

public class Weapon {

    String name;
    WeaponType weaponType;
    int damage;
    double attackSpeed;
    int levelRequirement;

    Random rand = new Random();

    public void generateRandomName(WeaponType weaponType){
        String[] descriptions = {"Bloody", "Cool", "Big", "Small", "Pink", "Very very very long", "The eternal", "Hobbit", "Noble", "Dwarf-forged", "Icy", "Flaming", "Garbage"};

        this.name = descriptions[rand.nextInt(descriptions.length)] + " " + weaponType;
        System.out.println("WeaponName = " + this.name);
    }
}
