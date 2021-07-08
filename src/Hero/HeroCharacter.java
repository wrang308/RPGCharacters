package Hero;

public class HeroCharacter {

    String name;
    int level;
    int experience;

    HeroType heroType;
    PrimaryAttributes primaryAttributes;
    SecondaryAttributes secondaryAttributes;

    // default constructor
    public HeroCharacter(){
        this.heroType = HeroType.Warrior;
        this.name = "default";
        this.level = 1;
        this.experience = 0;
        this.primaryAttributes = new PrimaryAttributes();
        this.secondaryAttributes = new SecondaryAttributes();
    }
    public HeroCharacter(String name, int level, int experience, HeroType heroType){
    this.name = name;
    this.level = level;
    this.experience = experience;
    this.heroType = heroType;
    this.primaryAttributes = new PrimaryAttributes();
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

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }



    public void setDefaultStats(){
        this.primaryAttributes.Strength = 1;
        this.primaryAttributes.Dexterity = 1;
        this.primaryAttributes.Intelligence = 1;
        this.primaryAttributes.Vitality = 1;
        this.secondaryAttributes.Health = 1;
        this.secondaryAttributes.ArmorRating = 1;
        this.secondaryAttributes.ElementalResistance =1;
    }

    void levelUp(){


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

    //TODO finish this
    public void printStats(){
        System.out.println("name = " + this.name);
        System.out.println("level = " + this.level);
        System.out.println("Strength = " + this.primaryAttributes.Strength);
        System.out.println("Dexterity = " + this.primaryAttributes.Dexterity);
        System.out.println("Intelligence = " + this.primaryAttributes.Intelligence);
        System.out.println("Vitality = " + this.primaryAttributes.Vitality);
        System.out.println("Health = " + this.secondaryAttributes.Health);
        System.out.println("ArmorRating = " + this.secondaryAttributes.ArmorRating);
        System.out.println("ElementalResistance = " + this.secondaryAttributes.ElementalResistance);
        System.out.println("DPS = " + this.secondaryAttributes.ElementalResistance);

    }

}
