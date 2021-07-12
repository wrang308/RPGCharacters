package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Warrior extends HeroCharacter {

    public Warrior(){
        this.setHeroType(HeroType.Warrior);
        this.setName("defualt");
        this.setLevel(1);
        this.setExperience(0);
        this.basePrimaryAttributes = new PrimaryAttributes(5,2,1,10);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setTotalPrimaryAttributes();
    }

    public Warrior(String name, int level){
        this.setName(name);
        this.setLevel(level);
        this.setHeroType(HeroType.Warrior);
        this.basePrimaryAttributes = new PrimaryAttributes(5,2,1,10);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setTotalPrimaryAttributes();

    }

    public Warrior(String name, int level, int experience, HeroType heroType) {
        super(name, level, experience, heroType);
    }

    public void getItem(){
        System.out.println(((Weapon)this.equipment.get(EquipmentSlot.Weapon)).getAttackSpeed());
    }

    @Override
    public double getDPS() {
        double weaponDPS = 1.0;
        if(this.equipment.get(EquipmentSlot.Weapon) != null){
            weaponDPS = ((Weapon)this.equipment.get(EquipmentSlot.Weapon)).getDPS();
        }

        double dps = weaponDPS * (1 + ((double)this.totalPrimaryAttributes.getStrength()/100));
        return Math.round(dps * 100d)/100d;
    }

    @Override
    public void setDefaultStats(){


    }

    @Override
    void levelUpStats(){
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength()+3);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity()+2);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence()+1);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality()+5);
    }

}
