package Hero;

import CustomExceptions.InvalidArmorException;
import CustomExceptions.InvalidWeaponException;
import Equipment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.RandomAccessFile;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    private Object InvalidWeaponException;
    Weapon Axe = new Weapon();


    @Test
    void TestCreateChar_ShouldExist() {
        Warrior warrior = new Warrior();
        assertNotNull(warrior);
    }
    @Test
    void TestLevelUp_LevelUp_2(){
        Mage character = new Mage();
        assertEquals(1,character.getLevel());
        character.levelUp(1);
        assertEquals(2,character.getLevel());
    }
    @Test
    void TestLevelUp_LevelUp0_ThrowArgumentException(){
        Mage character = new Mage();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            character.levelUp(0);
        });
    }
    @Test
    void TestAddExperienceAndLevelUp_AddExperienceAndLevelUp_2_0Experience(){
        Mage character = new Mage();
        character.addExperience(50);
        character.levelUp(1);
        assertEquals(2,character.getLevel());
        assertEquals(0, character.getExperience());
    }
    @Test
    void testAddExperience_add99_lvl1AndExpToNextLvl1(){
    Rogue character = new Rogue();
    character.addExperience(99);
        assertEquals(99, character.getExperience());
        assertEquals(1, character.getExperienceToNextLevel());
        assertEquals(1, character.getLevel());
    }
    @Test
    void testAddExperience_add0_lvl1AndExpToNextLvl100(){
        Rogue character = new Rogue();
        character.addExperience(0);
        assertEquals(0, character.getExperience());
        assertEquals(100, character.getExperienceToNextLevel());
        assertEquals(1, character.getLevel());
    }

    @Test
    void testAddExperience_add101_lvl2AndExpToNextLvl199(){
        Rogue character = new Rogue();

        character.addExperience(101);
        assertEquals(1,character.getExperience());
        assertEquals(199, character.getExperienceToNextLevel());
        assertEquals(2, character.getLevel());
    }
    @Test
    void testAddExperience_add1000_lvl5AndExpToNextLvl500(){
        Rogue character = new Rogue();

        character.addExperience(1000);
        assertEquals(0,character.getExperience());
        assertEquals(500, character.getExperienceToNextLevel());
        assertEquals(5, character.getLevel());
    }
    @Test
    void testWarriorCreationAttributes(){
        Warrior character = new Warrior();
        assertEquals(10,character.getBasePrimaryAttributes().getVitality());
        assertEquals(5,character.getBasePrimaryAttributes().getStrength());
        assertEquals(2,character.getBasePrimaryAttributes().getDexterity());
        assertEquals(1,character.getBasePrimaryAttributes().getIntelligence());
    }
    @Test
    void testMageCreationAttributes(){
        Mage character = new Mage();
        assertEquals(5,character.getBasePrimaryAttributes().getVitality());
        assertEquals(1,character.getBasePrimaryAttributes().getStrength());
        assertEquals(1,character.getBasePrimaryAttributes().getDexterity());
        assertEquals(8,character.getBasePrimaryAttributes().getIntelligence());
    }
    @Test
    void testRangerCreationAttributes(){
        Ranger character = new Ranger();
        assertEquals(8,character.getBasePrimaryAttributes().getVitality());
        assertEquals(1,character.getBasePrimaryAttributes().getStrength());
        assertEquals(7,character.getBasePrimaryAttributes().getDexterity());
        assertEquals(1,character.getBasePrimaryAttributes().getIntelligence());
    }
    @Test
    void testRogueCreationAttributes(){
        Rogue character = new Rogue();
        assertEquals(8,character.getBasePrimaryAttributes().getVitality());
        assertEquals(2,character.getBasePrimaryAttributes().getStrength());
        assertEquals(6,character.getBasePrimaryAttributes().getDexterity());
        assertEquals(1,character.getBasePrimaryAttributes().getIntelligence());
    }

    @Test
    void testWarriorLevelUpAttributes(){
        Warrior character = new Warrior();
        character.levelUp(1);
        assertEquals(15,character.getBasePrimaryAttributes().getVitality());
        assertEquals(8,character.getBasePrimaryAttributes().getStrength());
        assertEquals(4,character.getBasePrimaryAttributes().getDexterity());
        assertEquals(2,character.getBasePrimaryAttributes().getIntelligence());
    }
    @Test
    void testWarriorLevelUpAttributes1(){
        Warrior character = new Warrior();
        character.levelUp(1);
        assertEquals(15,character.getBasePrimaryAttributes().getVitality());
        assertEquals(8,character.getBasePrimaryAttributes().getStrength());
        assertEquals(4,character.getBasePrimaryAttributes().getDexterity());
        assertEquals(2,character.getBasePrimaryAttributes().getIntelligence());
    }
    @Test
    void testMageLevelUpAttributes(){
        Mage character = new Mage();
        character.levelUp(1);
        assertEquals(8,character.getBasePrimaryAttributes().getVitality());
        assertEquals(2,character.getBasePrimaryAttributes().getStrength());
        assertEquals(2,character.getBasePrimaryAttributes().getDexterity());
        assertEquals(13,character.getBasePrimaryAttributes().getIntelligence());
    }
    @Test
    void testRangerLevelUpAttributes(){
        Ranger character = new Ranger();
        character.levelUp(1);
        assertEquals(10,character.getBasePrimaryAttributes().getVitality());
        assertEquals(2,character.getBasePrimaryAttributes().getStrength());
        assertEquals(12,character.getBasePrimaryAttributes().getDexterity());
        assertEquals(2,character.getBasePrimaryAttributes().getIntelligence());
    }
    @Test
    void testRogueLevelUpAttributes(){
        Rogue character = new Rogue();
        character.levelUp(1);
        assertEquals(11,character.getBasePrimaryAttributes().getVitality());
        assertEquals(3,character.getBasePrimaryAttributes().getStrength());
        assertEquals(10,character.getBasePrimaryAttributes().getDexterity());
        assertEquals(2,character.getBasePrimaryAttributes().getIntelligence());
    }
    @Test
    void testCharacterName_Kalle_Kalle(){
        Ranger character = new Ranger();
        character.setName("Kalle");
        assertEquals("Kalle", character.getName());
    }
    @Test
    void testWeaponLevelRequirement_lvl2_ThrowInvalidWeaponException(){
        Warrior character = new Warrior();
        Weapon weapon = new Weapon();
        weapon.setLevelRequirement(2);
        Assertions.assertThrows(InvalidWeaponException.class, () -> {
            character.equipItem(weapon);
        });
    }
    @Test
    void testWeaponTypeRequirement_Bow_ThrowInvalidWeaponException(){
        Warrior character = new Warrior();
        Weapon weapon = new Weapon();
        weapon.setWeaponType(WeaponType.Bow);
        Assertions.assertThrows(InvalidWeaponException.class, () -> {
            character.equipItem(weapon);
        });
    }
    @Test
    void testArmorLevelRequirement_lvl2_ThrowInvalidArmorException(){
        Warrior character = new Warrior();
        Armor armor = new Armor(ArmorType.Plate,0,EquipmentSlot.Body);
        armor.setLevelRequirement(2);
        Assertions.assertThrows(InvalidArmorException.class, () -> {
            character.equipItem(armor);
        });
    }
    @Test
    void testArmorTypeRequirement_Cloth_ThrowInvalidArmorException(){
        Warrior character = new Warrior();
        Armor armor = new Armor(ArmorType.Cloth,0,EquipmentSlot.Body);
        Assertions.assertThrows(InvalidArmorException.class, () -> {
            character.equipItem(armor);
        });
    }
    @Test
    void EquipValidArmor_ValidArmor_True() throws InvalidArmorException, InvalidWeaponException {
        Warrior character = new Warrior();
        Armor armor = new Armor(ArmorType.Plate,0,EquipmentSlot.Body);
        assertTrue(character.equipItem(armor));
    }
    @Test
    void EquipValidWeapon_ValidWeapon_True() throws InvalidArmorException, InvalidWeaponException {
        Warrior character = new Warrior();
        Weapon weapon = new Weapon();
        weapon.setWeaponType(WeaponType.Sword);
        assertTrue(character.equipItem(weapon));
    }
    @Test
    void calculateDPS_WithNoWeaponEquiped_105() throws InvalidArmorException, InvalidWeaponException {
        Warrior character = new Warrior();
        assertEquals(1.05, character.getDPS());
    }
    @Test
    void calculateDPS_WithWeaponEquiped_809() throws InvalidArmorException, InvalidWeaponException {
        Warrior character = new Warrior();
        Weapon weapon = new Weapon();
        weapon.setWeaponType(WeaponType.Axe);
        weapon.setDamage(7);
        weapon.setAttackSpeed(1.1);
        character.equipItem(weapon);
        assertEquals(8.09, character.getDPS());
    }
    @Test
    void calculateDPS_WithWeaponAndArmorEquiped_816() throws InvalidArmorException, InvalidWeaponException {
        Warrior character = new Warrior();
        Weapon weapon = new Weapon();
        weapon.setWeaponType(WeaponType.Axe);
        weapon.setDamage(7);
        weapon.setAttackSpeed(1.1);
        character.equipItem(weapon);
        Armor armor = new Armor();
        armor.setSlot(EquipmentSlot.Body);
        armor.setArmorType(ArmorType.Plate);
        armor.setAttributes(new PrimaryAttributes(1,0,0,0));
        character.equipItem(armor);
        assertEquals(8.16, character.getDPS());
    }
    @Test
    void secondaryAttributes(){
        Warrior character = new Warrior();
        assertEquals(7,character.getSecondaryAttributes().getArmorRating());
        assertEquals(100,character.getSecondaryAttributes().getHealth());
        assertEquals(1,character.getSecondaryAttributes().getElementalResistance());
    }
    @Test
    void secondaryAttributes_WithArmor() throws InvalidArmorException, InvalidWeaponException {
        Warrior character = new Warrior();
        Armor armor = new Armor();
        armor.setSlot(EquipmentSlot.Body);
        armor.setArmorType(ArmorType.Plate);
        armor.setAttributes(new PrimaryAttributes(1,1,1,1));
        character.equipItem(armor);
        assertEquals(9,character.getSecondaryAttributes().getArmorRating());
        assertEquals(110,character.getSecondaryAttributes().getHealth());
        assertEquals(2,character.getSecondaryAttributes().getElementalResistance());
    }
    @Test
    void secondaryAttributes_WithArmorWithArmorRating() throws InvalidArmorException, InvalidWeaponException {
        Warrior character = new Warrior();
        Armor armor = new Armor();
        armor.setSlot(EquipmentSlot.Body);
        armor.setArmorType(ArmorType.Plate);
        armor.setAttributes(new PrimaryAttributes(1,1,1,1));
        armor.setArmorRating(1);
        character.equipItem(armor);
        assertEquals(10,character.getSecondaryAttributes().getArmorRating());
        assertEquals(110,character.getSecondaryAttributes().getHealth());
        assertEquals(2,character.getSecondaryAttributes().getElementalResistance());
    }

    @Test
    void checkPrintStats() throws InvalidArmorException, InvalidWeaponException {
        Warrior character = new Warrior();
        Armor armor = new Armor();
        armor.setSlot(EquipmentSlot.Body);
        armor.setArmorType(ArmorType.Plate);
        armor.setAttributes(new PrimaryAttributes(1,1,1,1));
        armor.setArmorRating(1);
        character.equipItem(armor);
        assertEquals("name = default\n" +
                "level = 1\n" +
                "experience = 0\n" +
                "experience to next level = 100\n" +
                "Strength = 6\n" +
                "Dexterity = 3\n" +
                "Intelligence = 2\n" +
                "Vitality = 11\n" +
                "Health = 110\n" +
                "Armor Rating = 10\n" +
                "Elemental Resistance = 2\n" +
                "DPS = 1.06", character.printStats());

    }



}
