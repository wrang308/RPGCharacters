package Hero;

public class Ranger extends HeroCharacter {

    public Ranger(String name, int level, int experience){
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.heroType = HeroType.Ranger;
        this.basePrimaryAttributes = new PrimaryAttributes();
        this.secondaryAttributes = new SecondaryAttributes();
        //setDefaultStats();
    }

    public void setDefaultStats(){
        this.basePrimaryAttributes.Strength = 1;
        this.basePrimaryAttributes.Dexterity = 7;
        this.basePrimaryAttributes.Intelligence = 1;
        this.basePrimaryAttributes.Vitality = 5;
        this.secondaryAttributes.Health = 1;
        this.secondaryAttributes.ArmorRating = 1;
        this.secondaryAttributes.ElementalResistance =1;
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

}
