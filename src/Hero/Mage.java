package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Mage extends HeroCharacter {

    public Mage(){
        this.setHeroType(HeroType.Mage);
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        totalPrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        secondaryAttributes = new SecondaryAttributes(1,1,1);
        //setDefaultStats();
    }

    public Mage(String name, int level){
        this.setName(name);
        this.setLevel(level);
        this.setHeroType(HeroType.Mage);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
    }



    public void setDefaultStats(){


    }

    @Override
    public int getTotalPrimaryAttributes() {
        return super.getTotalPrimaryAttributes();
    }

    public double getDPS(){
        double weaponDPS = 1.0;
        if(this.equipment.get(EquipmentSlot.Weapon) != null){
            weaponDPS = ((Weapon)this.equipment.get(EquipmentSlot.Weapon)).getDPS();
        }

        int totalStats = this.totalPrimaryAttributes.getDexterity() + this.totalPrimaryAttributes.getVitality() + this.totalPrimaryAttributes.getIntelligence() + this.totalPrimaryAttributes.getStrength();
        double dps = weaponDPS * (1+ ((double)(totalStats)/100)) * (1 + ((double)this.totalPrimaryAttributes.getIntelligence()/100));
        return Math.round(dps * 100d)/100d;
    }



    void levelUpStats(){

    }

}
