package Hero;

public class Mage extends HeroCharacter {

    public Mage(){
        this.heroType = HeroType.Mage;
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.totalPrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
        //setDefaultStats();
    }

    public Mage(String name, int level, int experience){
        this.setName(name);
        this.setLevel(level);
        this.setExperience(experience);
        this.heroType = HeroType.Mage;
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
    }

    public void setDefaultStats(){


    }

    public double getDPS(){




        return 1.0;
    }

    void levelUpStats(){


    }

}
