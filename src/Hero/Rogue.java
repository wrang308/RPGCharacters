package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Rogue extends HeroCharacter {

    public Rogue(){
        this.setHeroType(HeroType.Rogue);
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.basePrimaryAttributes = new PrimaryAttributes(2,6,1,8);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setTotalPrimaryAttributes();
    }

    public Rogue(String name, int level){
        this.setName(name);
        this.setLevel(level);
        this.setHeroType(HeroType.Rogue);
        this.basePrimaryAttributes = new PrimaryAttributes(2,6,1,8);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);

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

    @Override
    public void setDefaultStats(){


    }

    @Override
    void levelUpStats(){
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength()+1);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity()+4);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence()+1);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality()+3);
    }

}
