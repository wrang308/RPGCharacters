package Hero;

public class Mage extends HeroCharacter {

    public Mage(){
        this.heroType = HeroType.Mage;
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.totalPrimaryAttributes = new PrimaryAttributes();
        this.secondaryAttributes = new SecondaryAttributes();
        //setDefaultStats();
    }

    public Mage(String name, int level, int experience){
        this.setName(name);
        this.setLevel(level);
        this.setExperience(experience);
        this.heroType = HeroType.Mage;
        this.basePrimaryAttributes = new PrimaryAttributes();
        this.secondaryAttributes = new SecondaryAttributes();
    }

    public void setDefaultStats(){
        this.basePrimaryAttributes.Strength = 1;
        this.basePrimaryAttributes.Dexterity = 1;
        this.basePrimaryAttributes.Intelligence = 8;
        this.basePrimaryAttributes.Vitality = 5;
        this.secondaryAttributes.Health = 1;
        this.secondaryAttributes.ArmorRating = 1;
        this.secondaryAttributes.ElementalResistance =1;
    }

    void levelUpStats(){
        this.basePrimaryAttributes.Strength += 1;
        this.basePrimaryAttributes.Dexterity += 1;
        this.basePrimaryAttributes.Intelligence += 5;
        this.basePrimaryAttributes.Vitality += 3;
        this.secondaryAttributes.Health += 10;
        this.secondaryAttributes.ArmorRating += 0;
        this.secondaryAttributes.ElementalResistance += 0;
    }

}
