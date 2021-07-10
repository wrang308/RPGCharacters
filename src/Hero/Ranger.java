package Hero;

public class Ranger extends HeroCharacter {

    public Ranger(){
        this.setHeroType(HeroType.Ranger);
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
        this.setHeroType(HeroType.Ranger);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
        //setDefaultStats();
    }

    @Override
    public double getDPS() {
        return 0;
    }

    public void setDefaultStats(){


    }

    void levelUpStats(){


    }

}
