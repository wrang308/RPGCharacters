package Equipment;

import java.util.Random;

public class Weapon extends Equipment{

    public Weapon(){
        this.name = "default";
        this.slot = EquipmentSlot.Weapon;
        this.damage = 1;
        this.attackSpeed = 1.0;
        this.weaponType = WeaponType.Sword;
    }


    WeaponType weaponType;
    int damage;
    double attackSpeed;

    Random rand = new Random();

    public void generateRandomName(WeaponType weaponType){
        String[] descriptions = {"Bloody", "Cool", "Big", "Small", "Pink", "Very very very long", "The eternal", "Hobbit", "Noble", "Dwarf-forged", "Icy", "Flaming", "Garbage"};

        this.name = descriptions[rand.nextInt(descriptions.length)] + " " + weaponType;
        System.out.println("WeaponName = " + this.name);
    }
}
