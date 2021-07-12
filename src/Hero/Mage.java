package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Mage extends HeroCharacter {

    public Mage(){
        this.setHeroType(HeroType.Mage);
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,8,5);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setTotalPrimaryAttributes();
    }

    public Mage(String name, int level){
        this.setName(name);
        this.setLevel(level);
        this.setHeroType(HeroType.Mage);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,8,5);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setTotalPrimaryAttributes();
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

        double dps = weaponDPS * (1 + ((double)this.totalPrimaryAttributes.getIntelligence()/100));
        return Math.round(dps * 100d)/100d;
    }



    void levelUpStats(){
        System.out.println("level up stats");
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength()+1);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity()+1);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence()+5);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality()+3);
        }

}
