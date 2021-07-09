package Hero;

import Equipment.Equipment;

import java.util.Scanner;

public abstract class HeroCharacter {

    private String name;
    private int level;
    private int experience;

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

    HeroType heroType;
    PrimaryAttributes basePrimaryAttributes;
    PrimaryAttributes totalPrimaryAttributes;
    SecondaryAttributes secondaryAttributes;
    Equipment[] equipment = new Equipment[4];

    // default constructor
    public HeroCharacter(){
        this.heroType = HeroType.Warrior;
        this.name = "default";
        this.level = 1;
        this.experience = 0;
        this.totalPrimaryAttributes = new PrimaryAttributes();
        this.secondaryAttributes = new SecondaryAttributes();
        //setDefaultStats();
    }

    public HeroCharacter(String name, int level, int experience, HeroType heroType){
    this.name = name;
    this.level = level;
    this.experience = experience;
    this.heroType = heroType;
    this.basePrimaryAttributes = new PrimaryAttributes();
    this.secondaryAttributes = new SecondaryAttributes();
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

    void levelUp(){

        levelUpStats();
    }

    void levelUpStats(){
        this.basePrimaryAttributes.Strength += 1;
        this.basePrimaryAttributes.Dexterity += 1;
        this.basePrimaryAttributes.Intelligence += 1;
        this.basePrimaryAttributes.Vitality += 1;
        this.secondaryAttributes.Health += 10;
        this.secondaryAttributes.ArmorRating += 0;
        this.secondaryAttributes.ElementalResistance += 0;
    }

    public boolean equipItem(Equipment equipment){
        this.equipment[equipment.getSlot().ordinal()] = equipment;
        System.out.println(equipment.getName() + " equiped");
        // tried out some stuff
        /**
        if(this.equipment[equipment.getSlot().ordinal()] == null){
            System.out.println(equipment.getName() + " equiped");
            this.equipment[equipment.getSlot().ordinal()] = equipment;
        }else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to unequip " + this.equipment[equipment.getSlot().ordinal()].getName() + " 1/0?");
            int input = scanner.nextInt();

            if(input == 1){
                this.equipment[equipment.getSlot().ordinal()] = equipment;
                System.out.println(equipment.getName() + " equiped");
            }else{
                System.out.println(this.equipment[equipment.getSlot().ordinal()].getName() + " keeped");
            }
            scanner.close();

        }
         **/


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
        System.out.println("Strength = " + this.basePrimaryAttributes.Strength);
        System.out.println("Dexterity = " + this.basePrimaryAttributes.Dexterity);
        System.out.println("Intelligence = " + this.basePrimaryAttributes.Intelligence);
        System.out.println("Vitality = " + this.basePrimaryAttributes.Vitality);
        System.out.println("Health = " + this.secondaryAttributes.Health);
        System.out.println("ArmorRating = " + this.secondaryAttributes.ArmorRating);
        System.out.println("ElementalResistance = " + this.secondaryAttributes.ElementalResistance);
        System.out.println("DPS = " + this.secondaryAttributes.ElementalResistance);

    }

}
