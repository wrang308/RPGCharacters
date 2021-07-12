package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

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

    public Ranger(String name, int level){
        this.setName(name);
        this.setLevel(level);
        this.setHeroType(HeroType.Ranger);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
        //setDefaultStats();
    }

    @Override
    public double getDPS() {
        double weaponDPS = 1.0;
        if(this.equipment.get(EquipmentSlot.Weapon) != null){
            weaponDPS = ((Weapon)this.equipment.get(EquipmentSlot.Weapon)).getDPS();
        }

        int totalStats = this.totalPrimaryAttributes.getDexterity() + this.totalPrimaryAttributes.getVitality() + this.totalPrimaryAttributes.getIntelligence() + this.totalPrimaryAttributes.getStrength();
        double dps = weaponDPS * (1+ ((double)(totalStats)/100)) * (1 + ((double)this.totalPrimaryAttributes.getDexterity()/100));
        return Math.round(dps * 100d)/100d;
    }

    public void setDefaultStats(){


    }

    void levelUpStats(){


    }

}
