package DungeonAndDragon;

import java.util.Scanner;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

/*      ArrayList<Personnage> personnages = new ArrayList<Personnage>();
        Arme test = new Arme("hache", 15);
        personnages.add(new Guerrier("Jean", "img", 10, 10, test));
        personnages.add(new Guerrier("Edouard", "img", 10, 10, test));
*/

        Personnage[] personnages = new Personnage[20];
        int index = 0;

        boolean playGame = true;

        while (playGame == true) {

            System.out.println("Donjon et dragons, menu:");
            System.out.println("1 - Créer un Personnage.");
            System.out.println("2 - Liste des Personnages.");
            System.out.println("3 - Modifier un Personnage.");
            System.out.println("4 - Ce jeu est nul, quitter");
            System.out.println("Votre choix ? (1 / 2 / 3 / 4) :");

            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    boolean keepCreate = true;
                    //permet de boucler pour enchainer la création de perso
                    while (keepCreate == true) {

                        System.out.println("Veuillez choisir votre classe ( Guerrier -> 1 / Magicien -> 2 )");


                        int choice = sc.nextInt();
                        //ici le joueur choisis sa classe
                        sc.nextLine();

                        if (choice == 1) {
                            //cas Guerrier
                            System.out.println("Veuillez saisir votre nom :");
                            String nom = sc.nextLine();

                            System.out.println("Veuillez saisir votre image :");
                            String img = sc.nextLine();

                            System.out.println("Veuillez saisir votre arme :");
                            String armeName = sc.nextLine();

                            System.out.println("Veuillez saisir la puissance de votre arme :");
                            int armePuissance = sc.nextInt();
                            sc.nextLine();

                            //personnages.add(new Guerrier(nom, img, 10, 10, new Arme(armeName, armePuissance)));

                            personnages[index] = new Guerrier(nom, img, 10, 10, new Arme(armeName, armePuissance));
                            System.out.println(personnages[index].toString());
                            index++;



                            System.out.println("Voulez vous créer un autre Personnage ? ( oui / non ) ");
                            String keepCreateChoice = sc.nextLine();

                            if (("non").equals(keepCreateChoice)) {
                                keepCreate = false;
                            }
                        } else {
                            //cas Magicien
                            System.out.println("Veuillez saisir votre nom :");
                            String nom = sc.nextLine();

                            System.out.println("Veuillez saisir votre image :");
                            String img = sc.nextLine();

                            System.out.println("Veuillez saisir le nom de votre sort :");
                            String sortName = sc.nextLine();

                            System.out.println("Veuillez saisir la puissance de votre sort :");
                            int sortPuissance = sc.nextInt();
                            sc.nextLine();

                            //personnages.add(new Magicien(nom, img, 6, 15, new Sort(sortName, sortPuissance)));

                            personnages[index] = new Magicien(nom, img, 6, 15, new Sort(sortName, sortPuissance));
                            System.out.println(personnages[index].toString());
                            index++;


                            System.out.println("Voulez vous créer un autre Personnage ? ( oui / non ) ");
                            String keepCreateChoice = sc.nextLine();

                            if (("non").equals(keepCreateChoice)) {
                                keepCreate = false;
                            }
                        }
                    }
                    break;
                /*case 2:
                    System.out.println("Liste des personnages :");

                        for (int i = 0; i < personnages.size(); i++) {
                            System.out.print("(id = " + i + ") ");
                            System.out.println(personnages.get(i));
                        }

                    break;
                case 3:
                    System.out.println("Quel personnage souhaitez vous modifier ? (0-" + (personnages.size() - 1) + ")");
                    int editChoice = sc.nextInt();
                    Personnage temp = personnages.get(editChoice);
                    System.out.println(temp);

                    System.out.println("Que souhaitez vous modifier ?");
                    System.out.println("1 - Nom");
                    System.out.println("2 - Image");
                    System.out.println("3 - Supprimer");
                    System.out.println("Votre choix ? (1 / 2 / 3) :");
                    int editChoiceBis = sc.nextInt();
                    sc.nextLine();

                    switch (editChoiceBis){
                        case 1:
                            System.out.println("Veuillez saisir le nouveau nom :");
                            String nom = sc.nextLine();
                            temp.setNom(nom);
                            break;
                        case 2:
                            System.out.println("Veuillez saisir la nouvelle image:");
                            String img = sc.nextLine();
                            temp.setImage(img);
                            break;
                        case 3:
                            personnages.remove(editChoice);
                            break;
                    }
                    break;
                case 4:
                    playGame = false;
                    break;*/
            }
            System.out.println();
        }
    }
}