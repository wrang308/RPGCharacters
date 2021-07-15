package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Rogue extends HeroCharacter {

    public Rogue(){
        super("default",1,0,HeroType.Rogue,new PrimaryAttributes(2,6,1,8));
        setTotalPrimaryAttributes();
    }

    public Rogue(String name){
        super(name,1,0,HeroType.Rogue,new PrimaryAttributes(2,6,1,8));
        setTotalPrimaryAttributes();

    }

    /**
     * Increases the base PrimaryAttributes based of the Rogue HeroCharacter
     */
    @Override
    void levelUpStats(){
        this.getBasePrimaryAttributes().setStrength(this.getBasePrimaryAttributes().getStrength()+1);
        this.getBasePrimaryAttributes().setDexterity(this.getBasePrimaryAttributes().getDexterity()+4);
        this.getBasePrimaryAttributes().setIntelligence(this.getBasePrimaryAttributes().getIntelligence()+1);
        this.getBasePrimaryAttributes().setVitality(this.getBasePrimaryAttributes().getVitality()+3);
    }

}
