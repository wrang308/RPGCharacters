package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Warrior extends HeroCharacter {

    public Warrior(){
        super("default",1,0,HeroType.Warrior,new PrimaryAttributes(5,2,1,10));
        setTotalPrimaryAttributes();
    }

    public Warrior(String name, int level){
        super(name,1,0,HeroType.Warrior,new PrimaryAttributes(5,2,1,10));
        setTotalPrimaryAttributes();
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
