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
                Warrior warrior = new Warrior();
                warrior.getDPS();
                /*Ranger ranger = new Ranger("kalle", 10);
            ranger.setDefaultStats();
            ranger.printStats();
            HeroCharacter character1 = new Mage();
                System.out.println("int:"+ character1.getBasePrimaryAttributes().getIntelligence());
                System.out.println(character1.getDPS());
            character1.addExperience(999);
                System.out.println(character1.getDPS());
                System.out.println(character1.getExperience());
                System.out.println(character1.getExperienceToNextLevel());
                System.out.println("int:"+ character1.getBasePrimaryAttributes().getIntelligence());
            character1.getDPS();
            Weapon Atiesh = new Weapon(WeaponType.Staff,10.2 ,1);
            Atiesh.setAttributes(new PrimaryAttributes(1,10,1,1));

            Atiesh.setName("Atiesh");

                System.out.println(character1.getDPS());
                try {
                    character1.equipItem(Atiesh);
                }catch (Exception e){
                    System.out.println(e);
                }*/

            }

        }
    }
}
