package Equipment;

import Hero.PrimaryAttributes;

import java.util.jar.Attributes;

public abstract class Equipment {


    private String name;
    private int levelRequirement;
    private EquipmentSlot slot;
    private PrimaryAttributes primaryAttributes;
    Equipment(String name, int levelRequirement, EquipmentSlot slot, PrimaryAttributes primaryAttributes){
        this.name = name;
        this.levelRequirement = levelRequirement;
        this.slot = slot;
        this.primaryAttributes = primaryAttributes;
    }


    public PrimaryAttributes getAttributes() {
        return primaryAttributes;
    }

    public void setAttributes(PrimaryAttributes primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public EquipmentSlot getSlot() {
        return slot;
    }

    public void setSlot(EquipmentSlot slot) {
        this.slot = slot;
    }
}
