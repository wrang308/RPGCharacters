package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Warrior extends HeroCharacter {

    public Warrior(){
        this.heroType = HeroType.Warrior;
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.totalPrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
        //setDefaultStats();
    }

    public Warrior(String name, int level, int experience){
        this.setName(name);
        this.setLevel(level);
        this.setExperience(experience);
        this.heroType = HeroType.Warrior;
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
    }

    public Warrior(String name, int level, int experience, HeroType heroType) {
        super(name, level, experience, heroType);
    }

    public void getItem(){
        System.out.println(((Weapon)this.equipment.get(EquipmentSlot.Weapon)).getAttackSpeed());
    }


    @Override
    public void setDefaultStats(){


    }

    @Override
    void levelUpStats(){


    }

}
