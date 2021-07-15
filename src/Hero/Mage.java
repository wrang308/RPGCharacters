package Hero;

import Equipment.EquipmentSlot;
import Equipment.Weapon;

public class Mage extends HeroCharacter {

    public Mage(){
        super("default",1,0,HeroType.Mage,new PrimaryAttributes(1,1,8,5));
        setTotalPrimaryAttributes();
    }

    public Mage(String name){
        super(name,1,0,HeroType.Mage,new PrimaryAttributes(1,1,8,5));
        setTotalPrimaryAttributes();
    }

    /**
     * Increases the base PrimaryAttributes based of the Mage HeroCharacter
     */
    @Override
    void levelUpStats(){
        System.out.println("level up stats");
        this.getBasePrimaryAttributes().setStrength(this.getBasePrimaryAttributes().getStrength()+1);
        this.getBasePrimaryAttributes().setDexterity(this.getBasePrimaryAttributes().getDexterity()+1);
        this.getBasePrimaryAttributes().setIntelligence(this.getBasePrimaryAttributes().getIntelligence()+5);
        this.getBasePrimaryAttributes().setVitality(this.getBasePrimaryAttributes().getVitality()+3);
        }
}
