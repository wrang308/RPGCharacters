package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Warrior extends HeroCharacter {

    public Warrior(){
        this.setHeroType(HeroType.Warrior);
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.setBasePrimaryAttributes(new PrimaryAttributes(5,2,1,10));
        this.setSecondaryAttributes();
        setTotalPrimaryAttributes();
    }

    public Warrior(String name, int level){
        this.setName(name);
        this.setLevel(level);
        this.setHeroType(HeroType.Warrior);
        this.setBasePrimaryAttributes(new PrimaryAttributes(5,2,1,10));
        this.setSecondaryAttributes();
        setTotalPrimaryAttributes();

    }

    public Warrior(String name, int level, int experience, HeroType heroType) {
        super(name, level, experience, heroType);
    }

    /**
     * calculates the DPS based on the Warrior HeroCharacter. Strength increases the DPS for the Warrior class.
     * @return DPS of the Warrior HeroCharacter
     */
    @Override
    public double getDPS() {
        double weaponDPS = 1.0;
        if(this.getEquipment().get(EquipmentSlot.Weapon) != null){
            weaponDPS = ((Weapon)this.getEquipment().get(EquipmentSlot.Weapon)).getDPS();
        }

        double dps = weaponDPS * (1 + ((double)this.getTotalPrimaryAttributes().getStrength()/100));
        return Math.round(dps * 100d)/100d;
    }

    /**
     * Increases the base PrimaryAttributes based of the Warrior HeroCharacter
     */
    @Override
    void levelUpStats(){
        this.getBasePrimaryAttributes().setStrength(this.getBasePrimaryAttributes().getStrength()+3);
        this.getBasePrimaryAttributes().setDexterity(this.getBasePrimaryAttributes().getDexterity()+2);
        this.getBasePrimaryAttributes().setIntelligence(this.getBasePrimaryAttributes().getIntelligence()+1);
        this.getBasePrimaryAttributes().setVitality(this.getBasePrimaryAttributes().getVitality()+5);
    }

}
