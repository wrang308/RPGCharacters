package Hero;

import Equipment.Equipment;
import Equipment.EquipmentSlot;
import Equipment.*;

import java.util.HashMap;
import java.util.Scanner;

public abstract class HeroCharacter {

    private String name;
    private int level;
    private int experience;

    private HeroType heroType;
    PrimaryAttributes basePrimaryAttributes;
    PrimaryAttributes totalPrimaryAttributes;
    SecondaryAttributes secondaryAttributes;
    HashMap<EquipmentSlot, Equipment> equipment = new HashMap<EquipmentSlot, Equipment>();
    //HashMap <> equipment =
   // Equipment[] equipment = new Equipment[4];

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public void setBasePrimaryAttributes(PrimaryAttributes basePrimaryAttributes) {
        this.basePrimaryAttributes = basePrimaryAttributes;
    }

    public void setTotalPrimaryAttributes(PrimaryAttributes totalPrimaryAttributes) {
        this.totalPrimaryAttributes = totalPrimaryAttributes;
    }

    public void setSecondaryAttributes(SecondaryAttributes secondaryAttributes) {
        this.secondaryAttributes = secondaryAttributes;
    }



    // default constructor
    public HeroCharacter(){
        this.heroType = HeroType.Warrior;
        this.name = "default";
        this.level = 1;
        this.experience = 0;
        this.totalPrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
        //setDefaultStats();
    }

    public HeroCharacter(String name, int level, int experience, HeroType heroType){
    this.name = name;
    this.level = level;
    this.experience = experience;
    this.heroType = heroType;
    this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
    this.secondaryAttributes = new SecondaryAttributes(1,1,1);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public PrimaryAttributes getBasePrimaryAttributes() {
        return basePrimaryAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }



    public abstract void setDefaultStats();

    public abstract double getDPS();

    void levelUp(){

        levelUpStats();
    }

    void levelUpStats(){


    }

    public boolean equipItem(Equipment equipment){
        //System.out.println("a :" + this.getLevel() +  " b:" + equipment.getLevelRequirement());
        if(this.getLevel() < equipment.getLevelRequirement()){
            System.out.println("to low level to equip:" + equipment.getName());
            return false;
        }


        if(equipment.getSlot().equals(Armor.class)) {

            if (this.heroType == HeroType.Ranger || this.heroType == HeroType.Rogue && (((Armor) equipment).getArmorType() != ArmorType.Leather && ((Armor) equipment).getArmorType() != ArmorType.Mail)) {
                System.out.println("invalid armorType");
                return false;
            }
            if (this.heroType == HeroType.Warrior && (((Armor) equipment).getArmorType() != ArmorType.Plate && ((Armor) equipment).getArmorType() != ArmorType.Mail)) {
                System.out.println("invalid armorType");
                return false;
            }
            if (this.heroType == HeroType.Mage && ((Armor) equipment).getArmorType() != ArmorType.Cloth) {
                System.out.println("invalid armorType");
                return false;
            }

        }else if (equipment.getSlot().equals(Weapon.class)){

            if (this.heroType == HeroType.Ranger && (((Weapon) equipment).getWeaponType() != WeaponType.Bow)) {
                System.out.println("invalid armorType");
                return false;
            }
            if (this.heroType == HeroType.Rogue && (((Weapon) equipment).getWeaponType() != WeaponType.Dagger && ((Weapon) equipment).getWeaponType() != WeaponType.Sword)) {
                System.out.println("invalid armorType");
                return false;
            }
            if (this.heroType == HeroType.Warrior && (((Weapon) equipment).getWeaponType() != WeaponType.Hammer && ((Weapon) equipment).getWeaponType() != WeaponType.Sword) && ((Weapon) equipment).getWeaponType() != WeaponType.Axe) {
                System.out.println("invalid armorType");
                return false;
            }
            if (this.heroType == HeroType.Mage && (((Weapon) equipment).getWeaponType() != WeaponType.Sword && ((Weapon) equipment).getWeaponType() != WeaponType.Wand)) {
                System.out.println("invalid armorType");
                return false;
            }

        }


        //if(equipment.getSlot() == Equipment.EquipmentSlot.Weapon){


        this.equipment.put(equipment.getSlot(), equipment);
        System.out.println(equipment.getName() + " equiped");




        return true;
    }


    /**Character name
    • Character level
    • Strength
    • Dexterity
    • Intelligence
    • Health
    • Armor Rating
    • Elemental Resistance
    • DPS**/

    //TODO finish this and calculate the neccesary stuff
    public void printStats(){
        System.out.println("name = " + this.name);
        System.out.println("level = " + this.level);


    }

}
