package Equipment;

import Hero.PrimaryAttributes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    @Test
    void testWeaponExists(){
        Weapon weapon = new Weapon();
        assertNotNull(weapon);
    }
    @Test
    void testArmorExists(){
        Armor armor = new Armor();
        assertNotNull(armor);
    }

    @Test
    void testName(){
        Armor armor = new Armor();
        armor.setName("Kalle");
        assertEquals("Kalle", armor.getName());
    }

    @Test
    void testGenerateRandomName(){
        Armor armor = new Armor();
        armor.setName("Kalle");
        armor.generateRandomName(EquipmentSlot.Body);
        assertNotEquals("Kalle", armor.getName());
    }
    @Test
    void testWeaponAttackSpeed(){
        Weapon weapon = new Weapon();
        weapon.setAttackSpeed(1.0);
        assertEquals(1.0, weapon.getAttackSpeed());
    }
    @Test
    void testWeaponDamage(){
        Weapon weapon = new Weapon();
        weapon.setDamage(2.0);
        assertEquals(2.0, weapon.getDamage());
    }
    @Test
    void testWeaponType(){
        Weapon weapon = new Weapon();
        weapon.setWeaponType(WeaponType.Sword);
        assertSame(WeaponType.Sword, weapon.getWeaponType());
    }
    @Test
    void testWeaponAttributes(){
        Weapon weapon = new Weapon();
        weapon.setAttributes(new PrimaryAttributes(3,3,3,3));
        assertEquals(new PrimaryAttributes(3,3,3,3).getDexterity(), weapon.getAttributes().getDexterity());
        assertEquals(new PrimaryAttributes(3,3,3,3).getIntelligence(), weapon.getAttributes().getIntelligence());
        assertEquals(new PrimaryAttributes(3,3,3,3).getStrength(), weapon.getAttributes().getStrength());
        assertEquals(new PrimaryAttributes(3,3,3,3).getVitality(), weapon.getAttributes().getVitality());
    }
    @Test
    void testArmorAttributes(){
        Armor armor = new Armor();
        armor.setAttributes(new PrimaryAttributes(3,3,3,3));
        assertEquals(new PrimaryAttributes(3,3,3,3).getDexterity(), armor.getAttributes().getDexterity());
        assertEquals(new PrimaryAttributes(3,3,3,3).getIntelligence(), armor.getAttributes().getIntelligence());
        assertEquals(new PrimaryAttributes(3,3,3,3).getStrength(), armor.getAttributes().getStrength());
        assertEquals(new PrimaryAttributes(3,3,3,3).getVitality(), armor.getAttributes().getVitality());
    }






}