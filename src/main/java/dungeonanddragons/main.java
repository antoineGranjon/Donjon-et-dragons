/**
 * Programme du jeu Donjons et Dragons
 *
 * @author Antoine Granjon
 * @version 2.3
 */

package dungeonanddragons;

import armes.ArmesCollection;
import event.Bonus;
import event.Boss;
import event.Ennemi;
import personnages.*;
import exception.*;
import plateau.Plateau;
import sorts.Sort;

import java.util.Hashtable;
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

        ArrayList<Personnage> personnages = new ArrayList<Personnage>();
        //personnages.add(new Guerrier("Player name", "img", (5 + (int) (Math.random() * ((10 - 5) + 1))), (5 + (int) (Math.random() * ((10 - 5) + 1)))));

        int index = 0;

        boolean playGame = true;
        while (playGame == true) {

            System.out.println("Donjons et dragons, menu:");
            if (index >= 1) {
                System.out.println("0 - Jouer !");
            }
            System.out.println("1 - Créer un Personnage.");
            System.out.println("2 - Liste des Personnages.");
            System.out.println("3 - Modifier un Personnage.");
            System.out.println("4 - Ce jeu est nul, quitter");
            if (index >= 1) {
                System.out.println("Votre choix ? (0 / 1 / 2 / 3 / 4) :");

            } else {
                System.out.println("Votre choix ? (1 / 2 / 3 / 4) :");

            }
            String menu = sc.nextLine();

            switch (menu) {

                case "0":
                    displayArrayList(personnages);
                    System.out.println("Choisissez votre personnage(avec l'id): ");
                    int playerChoice = sc.nextInt();
                    playBoard(personnages.get(playerChoice));
                    break;
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

                                personnages.add(new Guerrier(nom, "img", (15 + (int) (Math.random() * ((25 - 15) + 1))), (5 + (int) (Math.random() * ((10 - 5) + 1)))));

                                System.out.println("                .\n" +
                                        "           .    |    .\n" +
                                        "            \\   |   /\n" +
                                        "        '.   \\  '  /   .'\n" +
                                        "          '. .'```'. .'\n" +
                                        "<>...:::::::`.......`:::::::..<>\n" +
                                        "<>:         Bienvenue        :<>\n" +
                                        "<>:..........................:<>\n" +
                                        "<><><><><><><><><><><><><><><><>");

                                System.out.println(personnages.get(index).toString());
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
                                int vieMagicien = (10 + (int) (Math.random() * ((15 - 10) + 1)));
                                int puissanceMagicien = (8 + (int) (Math.random() * ((15 - 8) + 1)));
                                String sort;
                                int sortPuissance;

                                try {
                                    if (nomMagicien.equals("jedusor"))
                                        throw new TestException();
                                    else {
                                        personnages.add(new Magicien(nomMagicien, "img", vieMagicien, puissanceMagicien));
                                        System.out.println(" / ~~~~~~~~~~~~~~~~~~~~~~~ \\\n" +
                                                "|  /~~\\               /~~\\  |\n" +
                                                "|\\ \\   |  Bienvenue  |   / /|\n" +
                                                "| \\   /|             |\\   / |\n" +
                                                "|  ~~  |             |  ~~  |\n" +
                                                "|      |             |      |\n" +
                                                " \\     |~~~~~~~~~~~~~|     /\n" +
                                                "  \\   /               \\   /\n" +
                                                "   ~~~                 ~~~");
                                    }
                                } catch (TestException e) {
                                    nomMagicien = "Voldemort";
                                    imgMagicien = " AAAA";
                                    sort = "Avada kedavra";
                                    vieMagicien = 700;
                                    puissanceMagicien = 1000;
                                    sortPuissance = 1000;
                                    personnages.add(new Magicien(nomMagicien, imgMagicien, vieMagicien, puissanceMagicien, new Sort(sort, sortPuissance)));
                                    System.out.println("\n" +
                                            "       ---_ ......._-_--.\n" +
                                            "      (|\\ /      / /| \\  \\\n" +
                                            "      /  /     .'  -=-'   `.\n" +
                                            "     /  /    .'             )\n" +
                                            "   _/  /   .'        _.)   /\n" +
                                            "  / o   o        _.-' /  .'\n" +
                                            "  \\          _.-'    / .'*|\n" +
                                            "   \\______.-'//    .'.' \\*|\n" +
                                            "    \\|  \\ | //   .'.' _ |*|\n" +
                                            "     `   \\|//  .'.'_ _ _|*|\n" +
                                            "      .  .// .'.' | _ _ \\*|\n" +
                                            "      \\`-|\\_/ /    \\ _ _ \\*\\\n" +
                                            "       `/'\\__/      \\ _ _ \\*\\\n" +
                                            "      /^|            \\ _ _ \\*\n" +
                                            "     '  `             \\ _ _ \\\n" +
                                            "                       \\_\n");
                                }

                                System.out.println(personnages.get(index).toString());
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
                    displayArrayList(personnages);
                    break;
                case "3":
                    displayArrayList(personnages);
                    System.out.println("Quel personnage souhaitez vous modifier ? (0-" + (personnages.size() - 1) + ")");
                    int editChoice = sc.nextInt();
                    Personnage temp = personnages.get(editChoice);

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
                            System.out.println("Votre nouveau nom: " + nom);

                            break;
                        case 2:
                            System.out.println("Veuillez saisir la nouvelle image:");
                            String img = sc.nextLine();
                            temp.setImage(img);
                            System.out.println("Votre nouvelle image: " + img);
                            break;
                        case 3:
                            System.out.println("Le personnage: " + personnages.get(editChoice).getNom() + " à bien été supprimer");
                            personnages.remove(editChoice);
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

    private static void playBoard(Personnage player) {
        Scanner sc = new Scanner(System.in);
        Hashtable plateau = new Hashtable();
        String[] tab = new String[2];
        tab[0] = "bonus";
        tab[1] = "ennemi";
        int pos = 0;
        int widthBoard = 10;
        boolean play = true;
        String boss = "boss";

        for (int i = 0; i < widthBoard; i++) {
            String caseTableau = tab[(int) (Math.random() * tab.length)];
            plateau.put(i, caseTableau);
        }
        plateau.put((widthBoard), boss);

        System.out.println("Bonne chance, " + player.getNom());

        while (play == true) {
            System.out.println("===================================================================================");
            System.out.println(player.getNom());
            System.out.println("Vie: " + player.getVie());
            System.out.println("Force: " + player.getForce());
            System.out.println("Votre arme: " + player.getArme());

            System.out.println("Plateau: ");
            for (int i = 0; i < plateau.size(); i++) {
                if (i != pos) {
                    System.out.print(" _ ");
                } else {
                    System.out.print(" | ");
                }
            }
            System.out.println(" ");

            String event = plateau.get(pos).toString();

            if (event.equals("bonus")) {
                Bonus randomBonus = Bonus.random();
                System.out.println("Vous êtes sur une case bonus !");
                System.out.println("Vous obtenez une " + randomBonus.getName());
                System.out.println("Vous gagnez " + randomBonus.getPuissance() + " puissance " + randomBonus.getVie() + " points de vie");
                player.setVie(player.getVie()+randomBonus.getVie());
                player.setForce(player.getForce()+randomBonus.getPuissance());
                System.out.println("Appuyer sur Entrée pour continuer");

                sc.nextLine();
                pos++;
            } else if (event.equals("ennemi")) {
                Ennemi randomEnnemi = Ennemi.random();
                int ennemyLife = randomEnnemi.getVie();
                System.out.println("Vous êtes sur une case ennemi !");
                System.out.println("Votre ennemi: " + randomEnnemi.getName() + " !");
                System.out.println("Il possède " + ennemyLife + " points de vie et " + randomEnnemi.getPuissance() + " de puissance");

                while (ennemyLife > 0) {
                    int dmg = (player.getForce() + player.getArmePuissance());
                    System.out.println("Vous infligez " + dmg + " points de dégats");
                    System.out.println(randomEnnemi.getName() + " vous inflige " + randomEnnemi.getPuissance() + " points de dégats");
                    player.setVie(player.getVie() - randomEnnemi.getPuissance());
                    if(player.getVie() < 1){
                        System.out.println("You lost");
                        System.out.println("Tu t'es fais soulevé par " + randomEnnemi.getName());
                        play = false;
                        break;
                    }
                    ennemyLife = ennemyLife - dmg;
                    System.out.println("Vos points de vie: " + player.getVie());
                    System.out.println("Les points de vie de l'adversaire: " + ennemyLife);
                    if(ennemyLife < 1 ){
                        System.out.println("Vous avez tué " + randomEnnemi.getName() + " !");
                    }

                    System.out.println("Appuyer sur Entrée pour continuer");
                    sc.nextLine();
                }
                pos++;
            }
            else if(event.equals("boss")){
                Boss randomBoss = Boss.random();
                int bossLife = randomBoss.getVie();
                System.out.println("Vous êtes face au boss !");
                System.out.println("Le boss " + randomBoss.getName() + " possède "+ bossLife + " points de vie et à " + randomBoss.getPuissance() + " points de force");

                while (bossLife > 0) {
                    int dmg = (player.getForce() + player.getArmePuissance());

                    System.out.println("Vous infligez " + dmg + " points de dégats");
                    System.out.println(randomBoss.getName() + " vous inflige " + randomBoss.getPuissance() + " points de dégats");
                    player.setVie(player.getVie() - randomBoss.getPuissance());
                    if(player.getVie() < 1){
                        System.out.println("You lost");
                        System.out.println("Dommage, tu viens de te faire soulevé par " + randomBoss.getName() + " comme la coupe en 98");
                        play = false;
                        break;
                    }
                    bossLife = bossLife - dmg;
                    System.out.println("Vos points de vie: " + player.getVie());
                    System.out.println("Les points de vie de l'adversaire: " + bossLife);
                    if(bossLife < 1 ){
                        System.out.println("Vous avez tué le boss " + randomBoss.getName() + " !");
                        System.out.println("You win !");
                    }

                    System.out.println("Appuyer sur Entrée pour continuer");
                    sc.nextLine();
                }
                play = false;
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