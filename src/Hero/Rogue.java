package Hero;

public class Rogue extends HeroCharacter {

    public Rogue(){
        this.setHeroType(HeroType.Rogue);
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.totalPrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
        setDefaultStats();
    }

    public Rogue(String name, int level, int experience){
        this.setName(name);
        this.setLevel(level);
        this.setExperience(experience);
        this.setHeroType(HeroType.Rogue);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
    }

    @Override
    public double getDPS() {
        return 0;
    }

    @Override
    public void setDefaultStats(){


    }

    @Override
    void levelUpStats(){


    }

}
