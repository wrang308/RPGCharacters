package Hero;

import CustomExceptions.InvalidArmorException;
import CustomExceptions.InvalidWeaponException;
import Equipment.Equipment;
import Equipment.EquipmentSlot;
import Equipment.*;

import java.util.HashMap;

public abstract class HeroCharacter {

    private String name;
    private int level;
    private int experience;

    private HeroType heroType;
    private PrimaryAttributes basePrimaryAttributes;
    private PrimaryAttributes totalPrimaryAttributes;
    private SecondaryAttributes secondaryAttributes;

    public PrimaryAttributes getTotalPrimaryAttributes() {
        return totalPrimaryAttributes;
    }

    public HashMap<EquipmentSlot, Equipment> getEquipment() {
        return this.equipment;
    }

    public void setEquipment(HashMap<EquipmentSlot, Equipment> equipment) {
        this.equipment = equipment;
    }

    private HashMap<EquipmentSlot, Equipment> equipment = new HashMap<EquipmentSlot, Equipment>();

    // default constructor
    public HeroCharacter(){
        this.heroType = HeroType.Warrior;
        this.name = "default";
        this.level = 1;
        this.experience = 0;
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,1,1);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        this.setTotalPrimaryAttributes();
    }

    public HeroCharacter(String name, int level, int experience, HeroType heroType,PrimaryAttributes primaryAttributes){
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.heroType = heroType;
        this.basePrimaryAttributes = primaryAttributes;
        this.secondaryAttributes = new SecondaryAttributes(1,1,1);
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the heroCharacter to wanted level and resets the experience
     * @param level the level you want the HeroCharacter to become
     */
    public void setLevel(int level) {
        this.level = level;
        this.experience = 0;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public void setBasePrimaryAttributes(PrimaryAttributes basePrimaryAttributes) {
        this.totalPrimaryAttributes = basePrimaryAttributes;
    }

    /**
     * Calculates the total amount of PrimaryAttributes a HeroCharacter have based on its basePrimaryAttributes and
     * the PrimaryAttributes connected to the Items. It also calls the setSecondaryAttributes to make sure that the
     * SecondaryAttributes are updated as well
     */
    public void setTotalPrimaryAttributes() {
        PrimaryAttributes primaryAttributes = basePrimaryAttributes;
        if(equipment.containsKey(EquipmentSlot.Weapon)){
            primaryAttributes.addDexterity(equipment.get(EquipmentSlot.Weapon).getAttributes().getDexterity());
            primaryAttributes.addStrength(equipment.get(EquipmentSlot.Weapon).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equipment.get(EquipmentSlot.Weapon).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equipment.get(EquipmentSlot.Weapon).getAttributes().getVitality());
        }
        if(equipment.containsKey(EquipmentSlot.Body)){
            primaryAttributes.addDexterity(equipment.get(EquipmentSlot.Body).getAttributes().getDexterity());
            primaryAttributes.addStrength(equipment.get(EquipmentSlot.Body).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equipment.get(EquipmentSlot.Body).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equipment.get(EquipmentSlot.Body).getAttributes().getVitality());
        }
        if(equipment.containsKey(EquipmentSlot.Head)){
            primaryAttributes.addDexterity(equipment.get(EquipmentSlot.Head).getAttributes().getDexterity());
            primaryAttributes.addStrength(equipment.get(EquipmentSlot.Head).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equipment.get(EquipmentSlot.Head).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equipment.get(EquipmentSlot.Head).getAttributes().getVitality());
        }
        if(equipment.containsKey(EquipmentSlot.Legs)){
            primaryAttributes.addDexterity(equipment.get(EquipmentSlot.Legs).getAttributes().getDexterity());
            primaryAttributes.addStrength(equipment.get(EquipmentSlot.Legs).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equipment.get(EquipmentSlot.Legs).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equipment.get(EquipmentSlot.Legs).getAttributes().getVitality());
        }
        this.totalPrimaryAttributes = primaryAttributes;
        setSecondaryAttributes();
    }

    /**
     * Calculates the total amount of SecondaryAttributes a HeroCharacter have based on its basePrimaryAttributes,
     * the PrimaryAttributes and armorRating connected to the Items.
     */
    public void setSecondaryAttributes() {
        int armorRating = 0;
        if(equipment.containsKey(EquipmentSlot.Body)){
            armorRating += ((Armor) equipment.get(EquipmentSlot.Body)).getArmorRating();
        }
        if(equipment.containsKey(EquipmentSlot.Head)){
            armorRating += ((Armor) equipment.get(EquipmentSlot.Body)).getArmorRating();
        }
        if(equipment.containsKey(EquipmentSlot.Legs)){
            armorRating += ((Armor) equipment.get(EquipmentSlot.Body)).getArmorRating();
        }
        this.getSecondaryAttributes().setArmorRating(armorRating + this.totalPrimaryAttributes.getDexterity() + this.totalPrimaryAttributes.getStrength());
        this.getSecondaryAttributes().setHealth(this.totalPrimaryAttributes.getVitality() * 10);
        this.getSecondaryAttributes().setElementalResistance(this.totalPrimaryAttributes.getIntelligence());
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public PrimaryAttributes getBasePrimaryAttributes() {
        return this.basePrimaryAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }

    /**
     * Calculates the DPS the HeroCharacter have. It checks i a Weapon is equipped or not. Dependant of the HeroClass the
     * HeroCharacter have it calculates the DPS dependant on the class special damage Attribute
     * @return double of the DPS that the HeroCharacter have
     */
    public double getDPS(){
        double weaponDPS = 1.0;
        if(this.getEquipment().get(EquipmentSlot.Weapon) != null){
            weaponDPS = ((Weapon)this.getEquipment().get(EquipmentSlot.Weapon)).getDPS();
        }
        double dps = 1.0;

        switch (this.heroType){
            case Warrior:
                dps = weaponDPS * (1 + ((double)this.getTotalPrimaryAttributes().getStrength())/100);
                break;
            case Mage:
                dps = weaponDPS * (1 + ((double)this.getTotalPrimaryAttributes().getIntelligence()/100));
                break;
            case Rogue:
            case Ranger:
                dps = weaponDPS * (1 + ((double)this.getTotalPrimaryAttributes().getDexterity()/100));
                break;
            default:
                dps = 1.0;
        }

        return Math.round(dps * 100d)/100d;
    }

    /**
     * Level up the HeroCharacter and the increases the basePrimaryAttributes. The Attributes depend on what class the
     * HeroCharacter is.
     * @param levels amount of levels you want the HeroCharacter to gain
     */
    void levelUp(int levels){
        if (levels < 1){
            throw new IllegalArgumentException("levels must be greater than zero");
        }
        this.setExperience(0);
        this.level = this.level +levels;
        levelUpStats();

    }

    /**
     * takes experience as parameter and calculates if the HeroCharacter has enough experience to level up.
     * It checks if the HeroCharacter should level up multiple times as well.
     * @param experience amount of experience you want to add to the HeroCharacter
     */
    public void  addExperience(int experience){
        this.setExperience(this.getExperience() + experience);
        while (this.experience >= (this.level * 100)) {
            this.setExperience(this.getExperience() - (this.level * 100));
            this.level = this.level + 1;
            levelUpStats();
        }
    }

    /**
     * Calculates amount of experience to next level
     * @return int amount of experience to next level
     */
    public int getExperienceToNextLevel(){
        return ((this.getLevel() * 100) - this.getExperience());
    }

    abstract void levelUpStats();

    /**
     *  Check if item is equippable and if check return true the Item is equipped a new totalBaseAttributes is set.
     * @param equipment The item you want the HeroCharacter to equip
     * @return boolean true if Item is equipped by HeroCharacter
     * @throws InvalidArmorException if Armor is to high level to equip or is the wrong ArmorType for the HeroCharacter
     * i.e Cloth for Warrior Exception is Thrown
     * @throws InvalidWeaponException if Weapon is to high level to equip or is the wrong WeaponType for the HeroCharacter
     * i.e Bow for Mage Exception is Thrown
     */
    public boolean equipItem(Equipment equipment) throws InvalidArmorException, InvalidWeaponException {

        if(checkEquippable(equipment)) {
            this.equipment.put(equipment.getSlot(), equipment);
            this.setTotalPrimaryAttributes();
            return true;
        }

        return false;
    }

    /**
     * Get an Equipment as parameter and checks if it is usable by the HeroCharacter.
     * If not usable an Exception is Thrown.
     * @param equipment Item you want to check if a HeroCharacter can equip.
     * @return boolean true if the HeroCharacter can equip the Item
     * @throws InvalidArmorException if Armor is to high level to equip or is the wrong ArmorType for the HeroCharacter
     *      * i.e Cloth for Warrior Exception is Thrown
     * @throws InvalidWeaponException if Weapon is to high level to equip or is the wrong WeaponType for the HeroCharacter
     *      * i.e Bow for Mage Exception is Thrown
     */
    private boolean checkEquippable(Equipment equipment) throws InvalidArmorException, InvalidWeaponException {

        if(!equipment.getSlot().equals(EquipmentSlot.Weapon)) {
            // checks for Armor
            if(this.getLevel() < equipment.getLevelRequirement()){
                throw new  InvalidArmorException("InvalidArmorException");
            }
            if (this.heroType == HeroType.Ranger || this.heroType == HeroType.Rogue && (((Armor) equipment).getArmorType() != ArmorType.Leather && ((Armor) equipment).getArmorType() != ArmorType.Mail)) {
                throw new  InvalidArmorException("InvalidArmorException");
            }
            if (this.heroType == HeroType.Warrior && (((Armor) equipment).getArmorType() != ArmorType.Plate && ((Armor) equipment).getArmorType() != ArmorType.Mail)) {
                throw new  InvalidArmorException("InvalidArmorException");
            }
            if (this.heroType == HeroType.Mage && ((Armor) equipment).getArmorType() != ArmorType.Cloth) {
                throw new  InvalidArmorException("InvalidArmorException");
            }

        }else if (equipment.getSlot().equals(EquipmentSlot.Weapon)){
            // check for Weapon
            if(this.getLevel() < equipment.getLevelRequirement()){
                throw new  InvalidWeaponException("InvalidWeaponException");
            }
            if (this.heroType == HeroType.Ranger && (((Weapon) equipment).getWeaponType() != WeaponType.Bow)) {
                throw new InvalidWeaponException("InvalidWeaponException");
            }
            if (this.heroType == HeroType.Rogue && (((Weapon) equipment).getWeaponType() != WeaponType.Dagger && ((Weapon) equipment).getWeaponType() != WeaponType.Sword)) {
                throw new InvalidWeaponException("InvalidWeaponException");
            }
            if (this.heroType == HeroType.Warrior && (((Weapon) equipment).getWeaponType() != WeaponType.Hammer && ((Weapon) equipment).getWeaponType() != WeaponType.Sword) && ((Weapon) equipment).getWeaponType() != WeaponType.Axe) {
                throw new InvalidWeaponException("InvalidWeaponException");
            }
            if (this.heroType == HeroType.Mage && (((Weapon) equipment).getWeaponType() != WeaponType.Sword && ((Weapon) equipment).getWeaponType() != WeaponType.Wand)) {
                throw new InvalidWeaponException("InvalidWeaponException");
            }

        }
        return true;
    }


    /**
     * Builds a String with info about the HeroCharacter and return the String
     * @return String with all the info that the HeroCharacter have
     */
    public String printStats(){
        StringBuilder returnString = new StringBuilder();
        returnString.append("name = " + this.name + "\n");
        returnString.append("level = " + this.level + "\n");
        returnString.append("experience = " + this.experience + "\n");
        returnString.append("experience to next level = " + getExperienceToNextLevel() + "\n");
        returnString.append("Strength = " + this.totalPrimaryAttributes.getStrength() + "\n");
        returnString.append("Dexterity = " + this.totalPrimaryAttributes.getDexterity() + "\n");
        returnString.append("Intelligence = " + this.totalPrimaryAttributes.getIntelligence() + "\n");
        returnString.append("Vitality = " + this.totalPrimaryAttributes.getVitality() + "\n");
        returnString.append("Health = " + this.secondaryAttributes.getHealth() + "\n");
        returnString.append("Armor Rating = " + this.secondaryAttributes.getArmorRating() + "\n");
        returnString.append("Elemental Resistance = " + this.secondaryAttributes.getElementalResistance() + "\n");
        returnString.append("DPS = " + this.getDPS());
        return returnString.toString();
    }
}
