package Equipment;

import Hero.PrimaryAttributes;

import java.util.Random;

public class Weapon extends Equipment {

    public Weapon(WeaponType weaponType, double damage, double attackSpeed) {
        super("default", 1, EquipmentSlot.Weapon, new PrimaryAttributes(0, 0, 0, 0));
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.setSlot(EquipmentSlot.Weapon);
    }

    public Weapon() {
        super("default", 1, EquipmentSlot.Weapon, new PrimaryAttributes(0, 0, 0, 0));
        this.damage = 1;
        this.attackSpeed = 1.0;
        this.weaponType = WeaponType.Sword;
        this.setAttributes(new PrimaryAttributes(0, 0, 0, 0));
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

    /**
     * calculates the DPS the weapon Item have
     *
     * @return DPS from the weapon Item
     */
    public double getDPS() {
        return attackSpeed * damage;
    }

    /**
     * Generates a random name for a weapon Item. Can be used instead of making a name yourself
     *
     * @param weaponType to determine what kind of weapon the name should have
     * @return String of the name of the generated name
     */
    public String generateRandomWeaponName(WeaponType weaponType) {
        Random rand = new Random();
        String[] descriptions = {"Bloody", "Cool", "Big", "Small", "Pink", "Very very very long", "The eternal", "Hobbit", "Noble", "Dwarf-forged", "Icy", "Flaming", "Garbage"};
        return descriptions[rand.nextInt(descriptions.length)] + " " + weaponType;
    }
}
