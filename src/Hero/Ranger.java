package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Ranger extends HeroCharacter {

    public Ranger(){
        super("default",1,0,HeroType.Ranger,new PrimaryAttributes(1,7,1,8));
        setTotalPrimaryAttributes();
    }

    public Ranger(String name){
        super(name,1,0,HeroType.Ranger,new PrimaryAttributes(1,7,1,8));
        setTotalPrimaryAttributes();
    }

    /**
     * Increases the base PrimaryAttributes based of the Ranger HeroCharacter
     */
    @Override
    void levelUpStats(){
        this.getBasePrimaryAttributes().setStrength(this.getBasePrimaryAttributes().getStrength()+1);
        this.getBasePrimaryAttributes().setDexterity(this.getBasePrimaryAttributes().getDexterity()+5);
        this.getBasePrimaryAttributes().setIntelligence(this.getBasePrimaryAttributes().getIntelligence()+1);
        this.getBasePrimaryAttributes().setVitality(this.getBasePrimaryAttributes().getVitality()+2);
    }

}
