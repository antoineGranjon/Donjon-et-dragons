package DungeonAndDragon;

import java.util.Scanner;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        /*Personnage[] personnages = new Personnage[20];
        int index = 0;*/

        System.out.println("        ,     \\    /      ,        \n" +
                "       / \\    )\\__/(     / \\       \n" +
                "      /   \\  (_\\  /_)   /   \\      \n" +
                " ____/_____\\__\\@  @/___/_____\\____ \n" +
                "|             |\\../|              |\n" +
                "|              \\VV/               |\n" +
                "|        Donjons et Dragons        |\n" +
                "|_________________________________ |\n" +
                " |    /\\ /      \\\\       \\ /\\    | \n" +
                " |  /   V        ))       V   \\  | \n" +
                " |/     `       //        '     \\| \n" +
                " `              V                '");

        try {
            play();
        } catch (java.util.InputMismatchException e) {
            System.out.println("!!! - Erreur, ce n'est pas un entier - !!!");
            play();
        }
    }

    public static void play() {
        Scanner sc = new Scanner(System.in);

        ArrayList<Personnage> personnages = new ArrayList<Personnage>();
        Arme test = new Arme("hache", 15);
        personnages.add(new Guerrier("Jean", "img", 10, 10, test));
        personnages.add(new Guerrier("Edouard", "img", 10, 10, test));
        boolean playGame = true;
        while (playGame == true) {

            System.out.println("Donjons et dragons, menu:");
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
                        sc.nextLine();
                        boolean keepAsking = true;

                        switch (choice) {
                            case 1:
                                //cas Guerrier
                                System.out.println("Veuillez saisir votre nom :");
                                String nom = sc.nextLine();

                                System.out.println("Veuillez saisir votre image :");
                                String img = sc.nextLine();
                                System.out.println("Veuillez saisir votre arme :");
                                String weapon = sc.nextLine();

                                System.out.println("Veuillez saisir la puissance de votre arme :");
                                int power = sc.nextInt();
                                sc.nextLine();

                                personnages.add(new Guerrier(nom, img, 10, 10, new Arme(weapon, power)));

                            /*personnages[index] = new Guerrier(nom, img, 10, 10, new Arme(armeName, armePuissance));
                            System.out.println(personnages[index].toString());
                            index++;*/

                                while (keepAsking == true) {
                                    boolean temp[] = keepCreating(keepCreate, keepAsking);
                                    keepCreate = temp[0];
                                    keepAsking = temp[1];
                                }
                                break;

                            case 2:
                                //cas Magicien
                                System.out.println("Veuillez saisir votre nom :");
                                String nomMagicien = sc.nextLine();

                                System.out.println("Veuillez saisir votre image :");
                                String imgMagicien = sc.nextLine();


                                System.out.println("Veuillez saisir le nom de votre sort :");
                                String spell = sc.nextLine();

                                System.out.println("Veuillez saisir la puissance de votre sort :");
                                int spellPower = sc.nextInt();
                                sc.nextLine();

                                personnages.add(new Magicien(nomMagicien, imgMagicien, 6, 15, new Sort(spell, spellPower)));

                            /*personnages[index] = new Magicien(nom, img, 6, 15, new Sort(sortName, sortPuissance));
                            System.out.println(personnages[index].toString());
                            index++;*/

                                while (keepAsking == true) {
                                    boolean temp[] = keepCreating(keepCreate, keepAsking);
                                    keepCreate = temp[0];
                                    keepAsking = temp[1];
                                }
                                break;

                            default:
                                System.out.println("Veuillez saisir un numéro valide !! ( Guerrier -> 1 / Mag1icien -> 2 ) ");
                                break;
                        }
                    }
                    break;
                case 2:
                    displayList(personnages);
                    break;
                case 3:
                    displayList(personnages);
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
                            personnages.remove(editChoice);
                            break;
                    }
                    break;
                case 4:
                    playGame = false;
                    sc.close();
                    break;
                default:
                    System.out.println("!!! - Veuillez choisir un numéro valide - !!! (1 / 2 / 3 / 4) ");
                    break;
            }
        }
    }

    public static void displayList(ArrayList tab) {
        System.out.println("Liste des personnages :");

        for (int i = 0; i < tab.size(); i++) {
            System.out.print("(id = " + i + ") ");
            System.out.println(tab.get(i));
        }
    }

    public static boolean[] keepCreating(boolean keepCreate, boolean keepAsking) {
        Scanner sc = new Scanner(System.in);

        boolean[] temp = new boolean[2];

        System.out.println("Voulez vous créer un autre Personnage ? ( oui / non ) ");
        String keepCreateChoice = sc.nextLine();

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