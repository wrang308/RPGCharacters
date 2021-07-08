import Equipment.Weapon;
import Equipment.WeaponType;
import Hero.HeroCharacter;
import Hero.HeroType;
import Hero.Warrior;

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
            HeroCharacter character = new HeroCharacter("kalle", 10, 500, HeroType.Mage);
            character.setDefaultStats();
            character.printStats();
            HeroCharacter character1 = new HeroCharacter();
            character1.setDefaultStats();
            character1.printStats();

                Warrior warrior = new Warrior();

                warrior.printStats();

                Weapon weapon = new Weapon();
                System.out.println(weapon.getName());
                weapon.generateRandomName(WeaponType.Hammer);
                System.out.println(weapon.getName());
            }



        }
    }
}
