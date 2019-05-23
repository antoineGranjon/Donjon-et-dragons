/**
 * Programme du jeu Donjons et Dragons
 *
 * @author Antoine Granjon
 * @version 2.3
 */

package dungeonanddragons;

import armes.Arme;
import armes.Armes;
import personnages.*;
import exception.*;
import sorts.Sort;

import java.util.Scanner;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {


        System.out.println("        ,     \\    /      ,        \n" +
                "       / \\    )\\__/(     / \\       \n" +
                "      /   \\  (_\\  /_)   /   \\      \n" +
                " ____/_____\\__\\@  @/___/_____\\____ \n" +
                "|             |\\../|              |\n" +
                "|              \\VV/               |\n" +
                "|        Donjons et Dragons       |\n" +
                "|_________________________________|\n" +
                " |    /\\ /      \\\\       \\ /\\    | \n" +
                " |  /   V        ))       V   \\  | \n" +
                " |/     `       //        '     \\| \n" +
                " `              V                '");
        play();
    }

    public static void play() {
        Scanner sc = new Scanner(System.in);

        Personnage[] personnages = new Personnage[50];

        int index = 0;

        /*ArrayList<Personnage> personnages = new ArrayList<Personnage>();*/

        boolean playGame = true;
        while (playGame == true) {

            System.out.println("Donjons et dragons, menu:");
            System.out.println("1 - Créer un Personnage.");
            System.out.println("2 - Liste des Personnages.");
            System.out.println("3 - Modifier un Personnage.");
            System.out.println("4 - Ce jeu est nul, quitter");
            System.out.println("Votre choix ? (1 / 2 / 3 / 4) :");
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    boolean keepCreate = true;
                    while (keepCreate == true) {

                        System.out.println("Veuillez choisir votre classe ( Guerrier -> 1 / Magicien -> 2 )");
                        String choice = sc.nextLine();

                        boolean keepAsking = true;

                        switch (choice) {
                            case "1":
                                System.out.println("Veuillez saisir votre nom :");
                                String nom = sc.nextLine();

                                personnages[index] = new Guerrier(nom, "img", (5 + (int) (Math.random() * ((10 - 5) + 1))), (5 + (int) (Math.random() * ((10 - 5) + 1))));

                                System.out.println("                .\n" +
                                        "           .    |    .\n" +
                                        "            \\   |   /\n" +
                                        "        '.   \\  '  /   .'\n" +
                                        "          '. .'```'. .'\n" +
                                        "<>...:::::::`.......`:::::::..<>\n" +
                                        "<>:         Bienvenue        :<>\n" +
                                        "<>:..........................:<>\n" +
                                        "<><><><><><><><><><><><><><><><>");

                                System.out.println(personnages[index].toString());
                                index++;


                                while (keepAsking == true) {
                                    boolean temp[] = keepCreating(keepCreate, keepAsking);
                                    keepCreate = temp[0];
                                    keepAsking = temp[1];
                                }
                                break;

                            case "2":
                                System.out.println("Veuillez saisir votre nom :");
                                String nomMagicien = sc.nextLine();
                                String imgMagicien;
                                int vieMagicien = (3 + (int) (Math.random() * ((6 - 3) + 1)));
                                int puissanceMagicien = (8 + (int) (Math.random() * ((15 - 8) + 1)));
                                String sort;
                                int sortPuissance;

                                try {
                                    if (nomMagicien.equals("jedusor"))
                                        throw new TestException();
                                    else {
                                        personnages[index] = new Magicien(nomMagicien, "img", vieMagicien, puissanceMagicien);
                                    }
                                } catch (TestException e) {
                                    nomMagicien = "Voldemort";
                                    imgMagicien = " AAAA";
                                    sort = "Avada kedavra";
                                    vieMagicien = 700;
                                    puissanceMagicien = 1000;
                                    sortPuissance = 1000;
                                    personnages[index] = new Magicien(nomMagicien, imgMagicien, vieMagicien, puissanceMagicien, new Sort(sort, sortPuissance));

                                }

                                System.out.println(" / ~~~~~~~~~~~~~~~~~~~~~~~ \\\n" +
                                        "|  /~~\\               /~~\\  |\n" +
                                        "|\\ \\   |  Bienvenue  |   / /|\n" +
                                        "| \\   /|             |\\   / |\n" +
                                        "|  ~~  |             |  ~~  |\n" +
                                        "|      |             |      |\n" +
                                        " \\     |~~~~~~~~~~~~~|     /\n" +
                                        "  \\   /               \\   /\n" +
                                        "   ~~~                 ~~~");

                                System.out.println(personnages[index].toString());
                                index++;

                                while (keepAsking == true) {
                                    boolean temp[] = keepCreating(keepCreate, keepAsking);
                                    keepCreate = temp[0];
                                    keepAsking = temp[1];
                                }
                                break;

                            default:
                                System.out.println("Veuillez saisir un numéro valide !! ( Guerrier -> 1 / Magicien -> 2 ) ");
                                break;
                        }
                    }
                    break;
                case "2":
                    displayList(personnages);
                    break;
                case "3":
                    displayList(personnages);
                    System.out.println("Quel personnage souhaitez vous modifier ? (0-" + (personnages.length - 1) + ")");
                    int editChoice = sc.nextInt();
                    Personnage temp = personnages[editChoice];

                    System.out.println(temp.toString());

                    System.out.println("Que souhaitez vous modifier ?");
                    System.out.println("1 - Nom");
                    System.out.println("2 - Image");
                    System.out.println("3 - Supprimer");
                    System.out.println("Votre choix ? (1 / 2 / 3) :");
                    int editChoiceBis = sc.nextInt();
                    sc.nextLine();

                    switch (editChoiceBis) {
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
                            for (int i = 0; i < personnages.length; i++) {
                                if (i == editChoice) {
                                    for (int j = i; j < personnages.length - 1; j++) {
                                        personnages[j] = personnages[j + 1];
                                    }
                                    break;
                                }
                            }
                            break;
                    }
                    break;
                case "4":
                    playGame = false;
                    sc.close();
                    break;
                default:
                    System.out.println("!!! - Veuillez choisir un numéro valide - !!! (1 / 2 / 3 / 4) ");
                    break;
            }
        }
    }

    /**
     * Méthode pour afficher la liste des perso avec une ArrayList
     *
     * @param tab
     * @return un affichage de la liste des personnages
     */
    public static void displayArrayList(ArrayList tab) {
        System.out.println("Liste des personnages :");

        for (int i = 0; i < tab.size(); i++) {
            System.out.print("(id = " + i + ") ");
            System.out.println(tab.get(i));
        }
    }

    /**
     * Afficher la liste des persos avec un tableau de personnages
     *
     * @param tab
     * @return un affichage de la liste des personnages
     */
    public static void displayList(Personnage[] tab) {
        System.out.println("Liste des personnages :");

        int i = 0;
        for (Personnage var : tab) {
            if (var != null) {
                System.out.print("(id = " + i + ") ");
                System.out.println(var.toString());
                i++;

            }
        }
    }

    /**
     * fonction qui demande à l'utilisateur si il veux continuer de créer un perso
     *
     * @param keepCreate
     * @param keepAsking
     * @return un tableau de boolean pour savoir si la boucle continue donc si on relance une création de perso
     */
    public static boolean[] keepCreating(boolean keepCreate, boolean keepAsking) {
        Scanner sc = new Scanner(System.in);

        boolean[] temp = new boolean[2];

        System.out.println("Voulez vous créer un autre Personnage ? ( oui / non ) ");
        String keepCreateChoice = sc.nextLine().toLowerCase();

        switch (keepCreateChoice) {
            case "oui":
                temp[0] = true;
                temp[1] = false;
                break;
            case "non":
                temp[0] = false;
                temp[1] = false;
                break;
            default:
                System.out.println("!!! - Veuillez saisir une réponse valide ( oui / non ) - !!!");
                break;
        }
        return temp;
    }
}