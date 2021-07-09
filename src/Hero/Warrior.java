package Hero;

public class Warrior extends HeroCharacter {

    public Warrior(){
        this.heroType = HeroType.Warrior;
        this.name = "default";
        this.level = 1;
        this.experience = 0;
        this.totalPrimaryAttributes = new PrimaryAttributes();
        this.secondaryAttributes = new SecondaryAttributes();
        //setDefaultStats();
    }

    public Warrior(String name, int level, int experience){
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.heroType = HeroType.Warrior;
        this.basePrimaryAttributes = new PrimaryAttributes();
        this.secondaryAttributes = new SecondaryAttributes();
    }


    @Override
    public void setDefaultStats(){
        this.basePrimaryAttributes.Strength = 5;
        this.basePrimaryAttributes.Dexterity = 2;
        this.basePrimaryAttributes.Intelligence = 1;
        this.basePrimaryAttributes.Vitality = 10;
        this.secondaryAttributes.Health = 1;
        this.secondaryAttributes.ArmorRating = 1;
        this.secondaryAttributes.ElementalResistance =1;
    }

    @Override
    void levelUpStats(){
        this.basePrimaryAttributes.Strength += 3;
        this.basePrimaryAttributes.Dexterity += 2;
        this.basePrimaryAttributes.Intelligence += 1;
        this.basePrimaryAttributes.Vitality += 3;
        this.secondaryAttributes.Health += 10;
        this.secondaryAttributes.ArmorRating += 0;
        this.secondaryAttributes.ElementalResistance += 0;
    }

}
