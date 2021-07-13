package Hero;

import CustomExceptions.InvalidArmorException;
import CustomExceptions.InvalidWeaponException;
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
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        this.setTotalPrimaryAttributes();
    }

    public HeroCharacter(String name, int level, int experience, HeroType heroType){
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.heroType = heroType;
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
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
        setSecondaryAttributes();
    }

    public void setSecondaryAttributes() {
        int armorRating = 0;
        if(equipment.containsKey(EquipmentSlot.Body)){
            armorRating += ((Armor) equipment.get(EquipmentSlot.Body)).getArmorRating();
        }
        if(equipment.containsKey(EquipmentSlot.Head)){
            armorRating += ((Armor) equipment.get(EquipmentSlot.Body)).getArmorRating();
        }
        if(equipment.containsKey(EquipmentSlot.Legs)){
            armorRating += ((Armor) equipment.get(EquipmentSlot.Body)).getArmorRating();
        }
        this.secondaryAttributes.setArmorRating(armorRating + this.totalPrimaryAttributes.getDexterity() + this.totalPrimaryAttributes.getStrength());
        this.secondaryAttributes.setHealth(this.totalPrimaryAttributes.getVitality() * 10);
        this.secondaryAttributes.setElementalResistance(this.totalPrimaryAttributes.getIntelligence());
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

        this.setExperience(0);
        this.level = this.level + 1;
        levelUpStats();
        setTotalPrimaryAttributes();

    }

    public void  addExperience(int experience){
        this.setExperience(this.getExperience() + experience);
        while (this.experience >= (this.level * 100)) {
            this.setExperience(this.getExperience() - (this.level * 100));
            this.level = this.level + 1;
            levelUpStats();
        }
        setTotalPrimaryAttributes();
    }

    public int getExperienceToNextLevel(){
        return ((this.getLevel() * 100) - this.getExperience());
    }

    abstract void levelUpStats();

    public boolean equipItem(Equipment equipment) throws InvalidArmorException, InvalidWeaponException {

        if(!equipment.getSlot().equals(EquipmentSlot.Weapon)) {

            if(this.getLevel() < equipment.getLevelRequirement()){
                throw new  InvalidArmorException("InvalidArmorException");
            }


            if (this.heroType == HeroType.Ranger || this.heroType == HeroType.Rogue && (((Armor) equipment).getArmorType() != ArmorType.Leather && ((Armor) equipment).getArmorType() != ArmorType.Mail)) {
                throw new  InvalidArmorException("InvalidArmorException");
            }
            if (this.heroType == HeroType.Warrior && (((Armor) equipment).getArmorType() != ArmorType.Plate && ((Armor) equipment).getArmorType() != ArmorType.Mail)) {
                throw new  InvalidArmorException("InvalidArmorException");
            }
            if (this.heroType == HeroType.Mage && ((Armor) equipment).getArmorType() != ArmorType.Cloth) {
                throw new  InvalidArmorException("InvalidArmorException");
            }

        }else if (equipment.getSlot().equals(EquipmentSlot.Weapon)){
            if(this.getLevel() < equipment.getLevelRequirement()){
                throw new  InvalidWeaponException("InvalidWeaponException");
            }

            if (this.heroType == HeroType.Ranger && (((Weapon) equipment).getWeaponType() != WeaponType.Bow)) {
                throw new InvalidWeaponException("InvalidWeaponException");
            }
            if (this.heroType == HeroType.Rogue && (((Weapon) equipment).getWeaponType() != WeaponType.Dagger && ((Weapon) equipment).getWeaponType() != WeaponType.Sword)) {
                throw new InvalidWeaponException("InvalidWeaponException");
            }
            if (this.heroType == HeroType.Warrior && (((Weapon) equipment).getWeaponType() != WeaponType.Hammer && ((Weapon) equipment).getWeaponType() != WeaponType.Sword) && ((Weapon) equipment).getWeaponType() != WeaponType.Axe) {
                throw new InvalidWeaponException("InvalidWeaponException");
            }
            if (this.heroType == HeroType.Mage && (((Weapon) equipment).getWeaponType() != WeaponType.Sword && ((Weapon) equipment).getWeaponType() != WeaponType.Wand)) {
                throw new InvalidWeaponException("InvalidWeaponException");
            }

        }

        this.equipment.put(equipment.getSlot(), equipment);
        System.out.println(equipment.getName() + " equiped");
        setTotalPrimaryAttributes();
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
