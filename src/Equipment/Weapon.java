package Equipment;

import Hero.PrimaryAttributes;

import java.util.Random;

public class Weapon extends Equipment{

    public Weapon(WeaponType weaponType, double damage, double attackSpeed) {
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.setSlot(EquipmentSlot.Weapon);
    }

    public Weapon(){
        this.setName("default");
        this.setSlot(EquipmentSlot.Weapon);
        this.damage = 2;
        this.attackSpeed = 1.0;
        this.weaponType = WeaponType.Sword;
        this.setAttributes(new PrimaryAttributes(0,0,0,0));
    }


    private WeaponType weaponType;
    private double damage;
    private double attackSpeed;


    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getDPS(){
        return attackSpeed * damage;
    }




    public void generateRandomName(WeaponType weaponType){
        Random rand = new Random();
        String[] descriptions = {"Bloody", "Cool", "Big", "Small", "Pink", "Very very very long", "The eternal", "Hobbit", "Noble", "Dwarf-forged", "Icy", "Flaming", "Garbage"};

        this.setName(descriptions[rand.nextInt(descriptions.length)] + " " + weaponType);
        System.out.println("WeaponName = " + this.getName());
    }
}
