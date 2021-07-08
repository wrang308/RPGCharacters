package Hero;

public class HeroCharacter {

    String name;
    int level;
    int experience;

    HeroType heroType;
    PrimaryAtributes primaryAtributes;
    SecondaryAttributes secondaryAttributes;

    // default constructor
    public HeroCharacter(){
        this.heroType = HeroType.Warrior;
        this.name = "default";
        this.level = 1;
        this.experience = 0;
        this.primaryAtributes = new PrimaryAtributes();
        this.secondaryAttributes = new SecondaryAttributes();
    }
    public HeroCharacter(String name, int level, int experience, HeroType heroType){
    this.name = name;
    this.level = level;
    this.experience = experience;
    this.heroType = heroType;
    this.primaryAtributes = new PrimaryAtributes();
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

    public PrimaryAtributes getPrimaryAtributes() {
        return primaryAtributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }



    public void setDefaultStats(){
        this.primaryAtributes.Strength = 1;
        this.primaryAtributes.Dexterity = 1;
        this.primaryAtributes.Intelligence = 1;
        this.primaryAtributes.Vitality = 1;
        this.secondaryAttributes.Health = 1;
        this.secondaryAttributes.ArmorRating = 1;
        this.secondaryAttributes.ElementalResistance =1;
    }

    void levelUp(int i){


    }



    public void printStats(){
        System.out.println("name = " + this.name);
        System.out.println("level = " + this.level);
        System.out.println("HeroType = " + this.heroType);
        System.out.println("Strength = " + this.primaryAtributes.Strength);
        System.out.println("Dexterity = " + this.primaryAtributes.Dexterity);
        System.out.println("Intelligence = " + this.primaryAtributes.Intelligence);
        System.out.println("Vitality = " + this.primaryAtributes.Vitality);
        System.out.println("Health = " + this.secondaryAttributes.Health);
        System.out.println("ArmorRating = " + this.secondaryAttributes.ArmorRating);
        System.out.println("ElementalResistance = " + this.secondaryAttributes.ElementalResistance);

    }

    public void printAtributes(){
        System.out.println("Strength            = " + this.primaryAtributes.Strength);
        System.out.println("Dexterity            = " + this.primaryAtributes.Dexterity);
        System.out.println("Intelligence        = " + this.primaryAtributes.Intelligence);
        System.out.println("Vitality            = " + this.primaryAtributes.Vitality);
        System.out.println("Health              = " + this.secondaryAttributes.Health);
        System.out.println("ArmorRating         = " + this.secondaryAttributes.ArmorRating);
        System.out.println("ElementalResistance = " + this.secondaryAttributes.ElementalResistance);

    }


}
