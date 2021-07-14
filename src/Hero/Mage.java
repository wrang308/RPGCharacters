package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Mage extends HeroCharacter {

    public Mage(){
        this.setHeroType(HeroType.Mage);
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.setBasePrimaryAttributes(new PrimaryAttributes(1,1,8,5));
        this.setSecondaryAttributes();
        setTotalPrimaryAttributes();
    }

    public Mage(String name, int level){
        this.setName(name);
        this.setLevel(level);
        this.setHeroType(HeroType.Mage);
        this.setBasePrimaryAttributes(new PrimaryAttributes(1,1,8,5));
        this.setSecondaryAttributes();
        setTotalPrimaryAttributes();
    }

    /**
     * calculates the DPS based on the Mage HeroCharacter. Intelligence increases the DPS for the Mage class
     * @return DPS of the Mage HeroCharacter
     */
    public double getDPS(){
        double weaponDPS = 1.0;
        if(this.equipment.get(EquipmentSlot.Weapon) != null){
            weaponDPS = ((Weapon)this.equipment.get(EquipmentSlot.Weapon)).getDPS();
        }

        double dps = weaponDPS * (1 + ((double)this.totalPrimaryAttributes.getIntelligence()/100));
        return Math.round(dps * 100d)/100d;
    }
    /**
     * Increases the base PrimaryAttributes based of the Mage HeroCharacter
     */
    @Override
    void levelUpStats(){
        System.out.println("level up stats");
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength()+1);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity()+1);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence()+5);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality()+3);
        }
}
