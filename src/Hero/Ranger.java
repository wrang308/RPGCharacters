package Hero;

public class Ranger extends HeroCharacter {

    public Ranger(){
        this.heroType = HeroType.Rogue;
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.totalPrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
        setDefaultStats();
    }

    public Ranger(String name, int level, int experience){
        this.setName(name);
        this.setLevel(level);
        this.setExperience(experience);
        this.heroType = HeroType.Ranger;
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
        //setDefaultStats();
    }

    public void setDefaultStats(){


    }

    void levelUpStats(){


    }

}
