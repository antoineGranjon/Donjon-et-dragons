package DungeonAndDragon;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        int keepCreate = 1;

        Scanner sc = new Scanner(System.in);

        while (keepCreate == 1) {

            System.out.println("Veuillez choisir votre classe ( Guerrier -> 1 / Magicien -> 2 )");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Veuillez saisir votre nom :");
                String nom = sc.nextLine();

                System.out.println("Veuillez saisir votre image :");
                String img = sc.nextLine();

                System.out.println("Veuillez saisir votre arme :");
                String armeName = sc.nextLine();

                System.out.println("Veuillez saisir la puissance de votre arme :");
                int armePuissance = sc.nextInt();
                sc.nextLine();

                Arme arme = new Arme(armeName, armePuissance);

                Guerrier guerrier = new Guerrier(nom, img, 10, 10, arme);

                System.out.println(guerrier.toString());

                System.out.println("Voulez vous créer un autre personnage ? ( oui / non ) ");
                String keepCreateChoice = sc.nextLine();

                if(("non").equals(keepCreateChoice)){
                    break;
                }

            } else {
                System.out.println("Veuillez saisir votre nom :");
                String nom = sc.nextLine();

                System.out.println("Veuillez saisir votre image :");
                String img = sc.nextLine();

                System.out.println("Veuillez saisir le nom de votre sort :");
                String sortName = sc.nextLine();

                System.out.println("Veuillez saisir la puissance de votre sort :");
                int sortPuissance = sc.nextInt();
                sc.nextLine();

                Sort sort = new Sort(sortName, sortPuissance);

                Magicien magicien = new Magicien(nom, img, 6, 15, sort);

                System.out.println(magicien.toString());

                System.out.println("Voulez vous créer un autre personnage ? ( oui / non ) ");
                String keepCreateChoice = sc.nextLine();

                if(("non").equals(keepCreateChoice)){
                    break;
                }

            }
        }
    }
}