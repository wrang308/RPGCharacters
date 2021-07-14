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
    /**
     * calculates the DPS based on the Rogue HeroCharacter. Dexterity increases the DPS for the Rogue class
     * @return DPS of the Rogue HeroCharacter
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
     * Increases the base PrimaryAttributes based of the Rogue HeroCharacter
     */
    @Override
    void levelUpStats(){
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength()+1);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity()+4);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence()+1);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality()+3);
    }

}
