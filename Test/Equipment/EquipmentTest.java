package Equipment;

import Hero.PrimaryAttributes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    @Test
    void CheckWeaponExists_shouldExist(){
        Weapon weapon = new Weapon();
        assertNotNull(weapon);
    }
    @Test
    void CheckArmorExists_ShouldExist(){
        Armor armor = new Armor();
        assertNotNull(armor);
    }

    @Test
    void CheckName_Kalle_Kalle(){
        Armor armor = new Armor();
        armor.setName("Kalle");
        assertEquals("Kalle", armor.getName());
    }

    @Test
    void CheckGenerateRandomName_Kalle_NotKalle(){
        Armor armor = new Armor();
        armor.setName("Kalle");
        assertNotEquals("Kalle", armor.generateRandomArmorName(EquipmentSlot.Body));
    }
    @Test
    void testWeaponAttackSpeed_1_1(){
        Weapon weapon = new Weapon();
        weapon.setAttackSpeed(1.0);
        assertEquals(1.0, weapon.getAttackSpeed());
    }
    @Test
    void testWeaponDamage_2_2(){
        Weapon weapon = new Weapon();
        weapon.setDamage(2.0);
        assertEquals(2.0, weapon.getDamage());
    }
    @Test
    void testWeaponType_Sword_Sword(){
        Weapon weapon = new Weapon();
        weapon.setWeaponType(WeaponType.Sword);
        assertSame(WeaponType.Sword, weapon.getWeaponType());
    }
    @Test
    void testWeaponAttributes_3333_3333(){
        Weapon weapon = new Weapon();
        weapon.setAttributes(new PrimaryAttributes(3,3,3,3));
        assertEquals(new PrimaryAttributes(3,3,3,3).getDexterity(), weapon.getAttributes().getDexterity());
        assertEquals(new PrimaryAttributes(3,3,3,3).getIntelligence(), weapon.getAttributes().getIntelligence());
        assertEquals(new PrimaryAttributes(3,3,3,3).getStrength(), weapon.getAttributes().getStrength());
        assertEquals(new PrimaryAttributes(3,3,3,3).getVitality(), weapon.getAttributes().getVitality());
    }
    @Test
    void testArmorAttributes_3333_3333(){
        Armor armor = new Armor();
        armor.setAttributes(new PrimaryAttributes(3,3,3,3));
        assertEquals(new PrimaryAttributes(3,3,3,3).getDexterity(), armor.getAttributes().getDexterity());
        assertEquals(new PrimaryAttributes(3,3,3,3).getIntelligence(), armor.getAttributes().getIntelligence());
        assertEquals(new PrimaryAttributes(3,3,3,3).getStrength(), armor.getAttributes().getStrength());
        assertEquals(new PrimaryAttributes(3,3,3,3).getVitality(), armor.getAttributes().getVitality());
    }






}