package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Ranger extends HeroCharacter {

    public Ranger(){
        this.setHeroType(HeroType.Ranger);
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.basePrimaryAttributes = new PrimaryAttributes(1,7,1,8);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setTotalPrimaryAttributes();
    }

    public Ranger(String name, int level){
        this.setName(name);
        this.setLevel(level);
        this.setHeroType(HeroType.Ranger);
        this.basePrimaryAttributes = new PrimaryAttributes(1,7,1,8);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setTotalPrimaryAttributes();
    }
    /**
     * calculates the DPS based on the Ranger HeroCharacter. Dexterity increases the DPS for the Ranger class
     * @return DPS of the Ranger HeroCharacter
     */
    @Override
    public double getDPS() {
        double weaponDPS = 1.0;
        if(this.equipment.get(EquipmentSlot.Weapon) != null){
            weaponDPS = ((Weapon)this.equipment.get(EquipmentSlot.Weapon)).getDPS();
        }

        double dps = weaponDPS * (1 + ((double)this.totalPrimaryAttributes.getDexterity()/100));
        return Math.round(dps * 100d)/100d;
    }
    /**
     * Increases the base PrimaryAttributes based of the Ranger HeroCharacter
     */
    @Override
    void levelUpStats(){
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength()+1);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity()+5);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence()+1);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality()+2);
    }

}
