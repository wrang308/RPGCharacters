package Equipment;

import java.util.Random;

public class Weapon extends Equipment{

    public Weapon(WeaponType weaponType, int damage, double attackSpeed) {
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public Weapon(){
        this.name = "default";
        this.slot = EquipmentSlot.Weapon;
        this.damage = 1;
        this.attackSpeed = 1.0;
        this.weaponType = WeaponType.Sword;
    }


    private WeaponType weaponType;
    private int damage;
    private double attackSpeed;


    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }




    public void generateRandomName(WeaponType weaponType){
        Random rand = new Random();
        String[] descriptions = {"Bloody", "Cool", "Big", "Small", "Pink", "Very very very long", "The eternal", "Hobbit", "Noble", "Dwarf-forged", "Icy", "Flaming", "Garbage"};

        this.name = descriptions[rand.nextInt(descriptions.length)] + " " + weaponType;
        System.out.println("WeaponName = " + this.name);
    }
}
