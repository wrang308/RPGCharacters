import Equipment.*;
import Hero.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to RPG Characters");
        Scanner scan = new Scanner(System.in);
        int input = 0;
        while(true){


            input = scan.nextInt();


            if (input == 1){
                System.out.println("hej");
            }
            if (input == 2){
                Ranger ranger = new Ranger("kalle", 10, 500);
            ranger.setDefaultStats();
            ranger.printStats();
            HeroCharacter character1 = new Mage();
            //character1.setDefaultStats();
            //character1.printStats();

                Warrior warrior = new Warrior();

                //warrior.printStats();

                Weapon weapon = new Weapon();
                Weapon weapon1 = new Weapon();

                Armor body = new Armor(ArmorType.Cloth, 1 ,EquipmentSlot.Body);
                body.setLevelRequirement(10);
                body.generateRandomName(body.getSlot());
                ranger.equipItem(body);

                weapon1.generateRandomName(WeaponType.Sword);
                System.out.println(weapon.getName());
                //weapon.generateRandomName(WeaponType.Hammer);
                System.out.println(weapon.getName());

                warrior.equipItem(weapon);
                warrior.equipItem(body);
                warrior.equipItem(weapon1);

                warrior.getItem();
            }



        }
    }
}
