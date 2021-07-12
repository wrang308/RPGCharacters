package Hero;

import Equipment.Equipment;
import Equipment.EquipmentSlot;
import Equipment.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.jar.Attributes;

public abstract class HeroCharacter {

    private String name;
    private int level;
    private int experience;

    private HeroType heroType;
    PrimaryAttributes basePrimaryAttributes;
    PrimaryAttributes totalPrimaryAttributes;
    SecondaryAttributes secondaryAttributes;
    HashMap<EquipmentSlot, Equipment> equipment = new HashMap<EquipmentSlot, Equipment>();


    // default constructor
    public HeroCharacter(){
        this.heroType = HeroType.Warrior;
        this.name = "default";
        this.level = 1;
        this.experience = 0;
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
        this.setTotalPrimaryAttributes();
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

    public PrimaryAttributes getEquipmentAttributes(){
        PrimaryAttributes attributes = new PrimaryAttributes(0,0,0,0);

        //attributes.setStrength(this.equipment.get(EquipmentSlot.Weapon).get);

        return attributes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
        this.experience = 0;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public void setBasePrimaryAttributes(PrimaryAttributes basePrimaryAttributes) {
        this.totalPrimaryAttributes = basePrimaryAttributes;
    }

    public void setTotalPrimaryAttributes() {
        PrimaryAttributes primaryAttributes = basePrimaryAttributes;
        if(equipment.containsKey(EquipmentSlot.Weapon)){
            primaryAttributes.addDexterity(equipment.get(EquipmentSlot.Weapon).getAttributes().getDexterity());
            primaryAttributes.addStrength(equipment.get(EquipmentSlot.Weapon).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equipment.get(EquipmentSlot.Weapon).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equipment.get(EquipmentSlot.Weapon).getAttributes().getVitality());
        }
        if(equipment.containsKey(EquipmentSlot.Body)){
            primaryAttributes.addDexterity(equipment.get(EquipmentSlot.Body).getAttributes().getDexterity());
            primaryAttributes.addStrength(equipment.get(EquipmentSlot.Body).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equipment.get(EquipmentSlot.Body).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equipment.get(EquipmentSlot.Body).getAttributes().getVitality());
        }
        if(equipment.containsKey(EquipmentSlot.Head)){
            primaryAttributes.addDexterity(equipment.get(EquipmentSlot.Head).getAttributes().getDexterity());
            primaryAttributes.addStrength(equipment.get(EquipmentSlot.Head).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equipment.get(EquipmentSlot.Head).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equipment.get(EquipmentSlot.Head).getAttributes().getVitality());
        }
        if(equipment.containsKey(EquipmentSlot.Legs)){
            primaryAttributes.addDexterity(equipment.get(EquipmentSlot.Legs).getAttributes().getDexterity());
            primaryAttributes.addStrength(equipment.get(EquipmentSlot.Legs).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equipment.get(EquipmentSlot.Legs).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equipment.get(EquipmentSlot.Legs).getAttributes().getVitality());
        }
        this.totalPrimaryAttributes = primaryAttributes;
    }

    public void setSecondaryAttributes(SecondaryAttributes secondaryAttributes) {
        this.secondaryAttributes = secondaryAttributes;
    }

    public PrimaryAttributes getTotalPrimaryAttributes1(){
        this.setTotalPrimaryAttributes();

        return this.totalPrimaryAttributes;
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
        return this.basePrimaryAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public int getTotalPrimaryAttributes(){
        return this.totalPrimaryAttributes.getVitality() + this.totalPrimaryAttributes.getStrength() + this.totalPrimaryAttributes.getDexterity() + this.totalPrimaryAttributes.getIntelligence();
        //return getBasePrimaryAttributes().getDexterity();// +basePrimaryAttributes.getIntelligence() + basePrimaryAttributes.getStrength() + basePrimaryAttributes.getVitality();
    }



    public abstract void setDefaultStats();

    public abstract double getDPS();

    void levelUp(){

        this.experience = this.experience - (this.level * 100);
        this.level++;
        System.out.println(this.getName() + " is now lvl " + this.level);
        levelUpStats();
        addExperience(0);
    }

    public void  addExperience(int experience){
        this.experience += experience;
        if (this.experience >= (this.level * 100)){
            levelUp();
        }
    }

    public int getExperienceToNextLevel(){
        return (this.level * 100) - this.experience;
    }

    abstract void levelUpStats();

    public boolean equipItem(Equipment equipment){

        if(this.getLevel() < equipment.getLevelRequirement()){
            System.out.println("to low level to equip:" + equipment.getName());
            return false;
        }
        System.out.println(equipment.getSlot());

        if(equipment.getSlot().equals(Armor.class)) {
        //if(!equipment.getSlot().equals(EquipmentSlot.Weapon)){
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
