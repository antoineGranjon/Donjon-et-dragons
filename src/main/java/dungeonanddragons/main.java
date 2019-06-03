/**
 * Programme du jeu Donjons et Dragons
 *
 * @author Antoine Granjon
 * @version 2.3
 */

package dungeonanddragons;

import event.Bonus;
import event.Boss_lvl_0;
import event.Boss_lvl_1;
import event.Ennemi_lvl_0;
import personnages.*;
import exception.*;
import sorts.Sort;

import java.util.Hashtable;
import java.util.List;
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

        List<AbstractPersonnage> personnages = new ArrayList<AbstractPersonnage>();
        //personnages.add(new Guerrier("Player name", "img", (5 + (int) (Math.random() * ((10 - 5) + 1))), (5 + (int) (Math.random() * ((10 - 5) + 1)))));


        boolean playGame = true;
        while (playGame == true) {

            boolean canPlay = !personnages.isEmpty();
            String menu = chooseAction(sc, canPlay);

            switch (menu) {

                case "0":
                    displayArrayList(personnages);
                    System.out.println("Choisissez votre personnage(avec l'id): ");
                    String playerChoice = sc.nextLine();
                    playBoard(personnages.get(Integer.parseInt(playerChoice)));
                    break;
                case "1":
                    boolean keepCreate = true;
                    while (keepCreate == true) {
                        System.out.println("Veuillez choisir votre classe ( Guerrier -> 1 / Magicien -> 2 )");
                        String choice = sc.nextLine();

                        boolean keepAsking = true;

                        System.out.println("Veuillez saisir votre nom :");
                        String nom = sc.nextLine();

                        switch (choice) {
                            case "1":
                                keepCreate = createGuerrier(personnages, keepCreate, keepAsking, nom, sc);
                                break;

                            case "2":
                                keepCreate = createMagicien(personnages, keepCreate, keepAsking, nom, sc);
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
                    modifierPerso(sc, personnages);
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

    private static void modifierPerso(Scanner sc, List<AbstractPersonnage> personnages) {
        displayArrayList(personnages);
        System.out.println("Quel personnage souhaitez vous modifier ? (0-" + (personnages.size() - 1) + ")");
        int editChoice = sc.nextInt();
        sc.nextLine();
        AbstractPersonnage temp = personnages.get(editChoice);

        System.out.println(temp.toString());

        System.out.println("Que souhaitez vous modifier ?");
        System.out.println("1 - Nom");
        System.out.println("2 - Image");
        System.out.println("3 - Supprimer");
        System.out.println("4 - Annuler la modification");
        System.out.println("Votre choix ? (1 / 2 / 3 / 4) :");
        String editChoiceBis = sc.nextLine();

        switch (editChoiceBis) {
            case "1":
                System.out.println("Veuillez saisir le nouveau nom :");
                String nom = sc.nextLine();
                temp.setNom(nom);
                System.out.println("Votre nouveau nom: " + nom);
                break;
            case "2":
                System.out.println("Veuillez saisir la nouvelle image:");
                String img = sc.nextLine();
                temp.setImage(img);
                System.out.println("Votre nouvelle image: " + img);
                break;
            case "3":
                System.out.println("Le personnage: " + personnages.get(editChoice).getNom() + " à bien été supprimer");
                personnages.remove(editChoice);
                break;
            case "4":
                System.out.println("Retour au menu précédent ...");
                break;
            default:
                break;
        }
        return;
    }

    private static boolean createMagicien(List<AbstractPersonnage> personnages, boolean keepCreate, boolean keepAsking, String nom, Scanner sc) {
        String imgMagicien;
        int vieMagicien = (10 + (int) (Math.random() * ((15 - 10) + 1)));
        int puissanceMagicien = (8 + (int) (Math.random() * ((15 - 8) + 1)));
        String sort;
        int sortPuissance;
        Magicien justCreated;

        try {
            if (nom.equals("jedusor"))
                throw new TestException();
            else {
                justCreated = new Magicien(nom, "img", vieMagicien, puissanceMagicien);
                personnages.add(justCreated);
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
            nom = "Voldemort";
            imgMagicien = " AAAA";
            sort = "Avada kedavra";
            vieMagicien = 700;
            puissanceMagicien = 1000;
            sortPuissance = 1000;
            justCreated = new Magicien(nom, imgMagicien, vieMagicien, puissanceMagicien, new Sort(sort, sortPuissance));
            personnages.add(justCreated);
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

        System.out.println(justCreated.toString());

        while (keepAsking == true) {
            boolean temp[] = keepCreating(sc, keepCreate, keepAsking);
            keepCreate = temp[0];
            keepAsking = temp[1];
        }
        return keepCreate;
    }

    private static boolean createGuerrier(List<AbstractPersonnage> personnages, boolean keepCreate, boolean keepAsking, String nom, Scanner sc) {
        Guerrier justCreated = new Guerrier(nom, "img", (15 + (int) (Math.random() * ((25 - 15) + 1))), (5 + (int) (Math.random() * ((10 - 5) + 1))));
        personnages.add(justCreated);

        System.out.println("                .\n" +
                "           .    |    .\n" +
                "            \\   |   /\n" +
                "        '.   \\  '  /   .'\n" +
                "          '. .'```'. .'\n" +
                "<>...:::::::`.......`:::::::..<>\n" +
                "<>:         Bienvenue        :<>\n" +
                "<>:..........................:<>\n" +
                "<><><><><><><><><><><><><><><><>");

        System.out.println(justCreated.toString());

        while (keepAsking == true) {
            boolean temp[] = keepCreating(sc, keepCreate, keepAsking);
            keepCreate = temp[0];
            keepAsking = temp[1];
        }
        return keepCreate;
    }

    private static String chooseAction(Scanner sc, boolean canPlay) {
        System.out.println("Donjons et dragons, menu:");
        if (canPlay) {
            System.out.println("0 - Jouer !");
        }
        System.out.println("1 - Créer un personnage.");
        System.out.println("2 - Liste des personnages.");
        System.out.println("3 - Modifier un personnage.");
        System.out.println("4 - Ce jeu est nul, quitter");
        if (canPlay) {
            System.out.println("Votre choix ? (0 / 1 / 2 / 3 / 4) :");

        } else {
            System.out.println("Votre choix ? (1 / 2 / 3 / 4) :");

        }
        return sc.nextLine();
    }

    private static void playBoard(AbstractPersonnage player) {
        Scanner sc = new Scanner(System.in);
        Hashtable plateau = new Hashtable();

        String[] tab = new String[2];
        tab[0] = "bonus";
        tab[1] = "ennemi";
        int pos = 0;
        int lvl = 1;
        int widthBoard = 10;
        boolean play = true;
        String boss = "boss";

        remplirTab(plateau, tab, widthBoard, boss, lvl);

        lvl = level_0(player, sc, plateau, pos, lvl, play);

        widthBoard = 20;

        remplirTab(plateau, tab, widthBoard, boss, lvl);

        lvl = level_0(player, sc, plateau, pos, lvl, play);
    }

    private static void remplirTab(Hashtable plateau, String[] tab, int widthBoard, String boss, int lvl) {
        for (int i = 0; i < widthBoard; i++) {
            if ((i == 9 && lvl == 2) || (i == 14 && lvl == 2)) {
                String choix = "choix";
                plateau.put(i, choix);
            } else {
                String caseTableau = tab[(int) (Math.random() * tab.length)];
                plateau.put(i, caseTableau);
            }

        }
        plateau.put((widthBoard), boss);
    }

    private static int level_0(AbstractPersonnage player, Scanner sc, Hashtable plateau, int pos, int lvl, boolean play) {
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
                pos = new RandomBonus(player, sc, pos).invoke();
            } else if (event.equals("ennemi")) {
                Ennemi_lvl_0 randomEnnemi = Ennemi_lvl_0.random();
                int ennemyLife = randomEnnemi.getVie();
                System.out.println("Vous êtes sur une case ennemi !");
                System.out.println("Votre ennemi: " + randomEnnemi.getName() + " !");
                System.out.println("Il possède " + ennemyLife + " points de vie et " + randomEnnemi.getPuissance() + " de puissance");

                while (ennemyLife > 0) {
                    int dmg = (player.getForce() + player.getArmePuissance());
                    System.out.println("Vous infligez " + dmg + " points de dégats");
                    System.out.println(randomEnnemi.getName() + " vous inflige " + randomEnnemi.getPuissance() + " points de dégats");
                    player.setVie(player.getVie() - randomEnnemi.getPuissance());
                    if (player.getVie() < 1) {
                        System.out.println("You lost");
                        System.out.println("Tu t'es fais DÉTRUIRE par " + randomEnnemi.getName());
                        play = false;
                        break;
                    }
                    ennemyLife = ennemyLife - dmg;
                    System.out.println("Vos points de vie: " + player.getVie());
                    System.out.println("Les points de vie de l'adversaire: " + ennemyLife);
                    if (ennemyLife < 1) {
                        System.out.println("Vous avez tué " + randomEnnemi.getName() + " !");
                    }

                    System.out.println("Appuyer sur Entrée pour continuer");
                    sc.nextLine();
                }
                pos++;
            } else if (event.equals("choix")) {
                switch (pos) {
                    case 9:
                        pos = eventNeuf(player, sc, pos);
                        break;
                    case 14:
                        boolean choice = true;
                        while (choice) {
                            System.out.println("Vous entrez dans une pièce qui ressemble étrangement à l'intérieur du little warung");
                            System.out.println("Que voulez vous commmander ?");
                            System.out.println("A) Hanoï riz blanc (tmtc les bails)");
                            System.out.println("B) Mekong riz nouilles");
                            System.out.println("C) Aller chez big pour commander un Américain sans frite");
                            System.out.println("D) Encore la réponse D (c'est pas une bonne idée si tu veux mon avis)");
                            String choix = sc.nextLine();
                            switch (choix.toLowerCase()) {
                                case "a":
                                    System.out.println("Un hanoï riz blanc j'vois que t'es un connaisseur, tiens tu va avancer de 2 cases et tu prends un bonus de 50 points de vie mets toi ienb mon bro ");
                                    player.setVie(player.getVie() + 50);
                                    pos++;
                                    choice = false;
                                    break;
                                case "b":
                                    System.out.println("Ouais pas mal mais ca vaux pas un hanoï riz blanc, tu gagnes 20 points de vie et 20 de force ");
                                    player.setVie(player.getVie() + 20);
                                    player.setForce(player.getVie() + 20);
                                    pos++;
                                    choice = false;
                                    break;
                                case "c":
                                    System.out.println("Mais t'as cru qu'on étais à Valence ? T'es dans un donjon la aller -20 points de vie tu m'as saoulé");
                                    player.setForce(player.getVie() - 20);
                                    choice = false;
                                    break;
                                case "d":
                                    System.out.println("Bien joué tu peux aller jusqu'au boss");
                                    pos = 20;
                                    lvl = 666;
                                    choice = false;
                                    break;
                                default:
                                    System.out.println("MAUVAIS CHOIX");
                                    break;
                            }
                        }
                        break;
                }

                System.out.println("Appuyer sur Entrée pour continuer");
                sc.nextLine();
            } else if (event.equals("boss")) {
                String bossName = "";
                int bossPower = 0;
                int bossLife = 0;

                if (lvl == 1) {
                    Boss_lvl_0 randomBoss = Boss_lvl_0.random();
                    bossName = randomBoss.getName();
                    bossPower = randomBoss.getPuissance();
                    bossLife = randomBoss.getVie();
                } else if (lvl == 2) {
                    Boss_lvl_1 randomBoss = Boss_lvl_1.random();
                    bossName = randomBoss.getName();
                    bossPower = randomBoss.getPuissance();
                    bossLife = randomBoss.getVie();
                }
                else if(lvl == 666){
                    bossName = "La réponse D";
                    bossPower = 666666;
                    bossLife = 666666;
                }

                System.out.println("Vous êtes face au boss !");
                System.out.println("Le boss " + bossName + " possède " + bossLife + " points de vie et à " + bossPower + " points de force");

                while (bossLife > 0) {
                    int dmg = (player.getForce() + player.getArmePuissance());

                    System.out.println("Vous infligez " + dmg + " points de dégats");
                    System.out.println(bossName + " vous inflige " + bossPower + " points de dégats");
                    player.setVie(player.getVie() - bossPower);
                    if (player.getVie() < 1) {
                        System.out.println("You lost");
                        System.out.println("Dommage, tu viens de te faire soulevé par " + bossName + " comme la coupe en 98");
                        play = false;
                        break;
                    }
                    bossLife = bossLife - dmg;
                    System.out.println("Vos points de vie: " + player.getVie());
                    System.out.println("Les points de vie de l'adversaire: " + bossLife);
                    if (bossLife < 1) {
                        System.out.println("Vous avez tué le boss " + bossName + " !");
                        System.out.println("•_•)");
                        System.out.println("( •_•)>⌐■-■");
                        System.out.println("(⌐■_■)");
                        System.out.println("You win !");
                        System.out.println("Vous appercevez une porte derrière le cadavre de " + bossName + "...");
                        lvl++;
                    }

                    System.out.println("Appuyer sur Entrée pour continuer");
                    sc.nextLine();
                }
                play = false;
            }
        }
        return lvl;
    }

    private static int eventNeuf(AbstractPersonnage player, Scanner sc, int pos) {
        boolean choice = true;
        while (choice) {
            System.out.println("Vous entrez dans une pièce, il y a 3 coffres devant vous mais vous ne pouvez en ouvrir qu'un...");
            System.out.println("Le quel voulez vous ouvrir ?");
            System.out.println("A) Le premier");
            System.out.println("B) Le deuxième");
            System.out.println("C) Le troisième");
            System.out.println("D) La réponse D");
            String choix = sc.nextLine();
            switch (choix.toLowerCase()) {
                case "a":
                    System.out.println("Il y a un bouton à l'intérieur, il ouvre un passage secret qui vous ammène 3 salles plus loin");
                    pos = pos + 2;
                    choice = false;
                    break;
                case "b":
                    System.out.println("Vous trouvez un anneau qui vous octroie 15 de puissance et 15 de vie");
                    player.setVie(player.getVie() + 15);
                    player.setForce(player.getVie() + 15);
                    pos++;
                    choice = false;
                    break;
                case "c":
                    boolean potion = true;
                    while(potion == true){
                    System.out.println("Vous trouvez une potion étrange, voulez-vous la boire ?");
                    String choixPotion =sc.nextLine();
                    switch (choixPotion){
                        case"oui":
                            System.out.println("Vous buvez la potion, vous vous sentez pas super");
                            System.out.println("Vous perdez 15 points de force");
                            player.setForce(player.getForce() - 15);
                            pos++;
                            potion = false;
                            break;
                        case"non":
                            System.out.println("Vous étiez trop hésitant, la potion vous à éxploser dans les mains");
                            System.out.println("Vous perdez 15 points de vie");
                            player.setVie(player.getVie() - 15);
                            pos++;
                            potion = false;
                            break;
                            default:
                                System.out.println("Mauvaise réponse");
                                break;
                    }}
                    choice = false;
                    break;
                case "d":
                    System.out.println("Tu trouves ça marrant ? Aller hop tu retournes au début du niveau ça t'apprendras");
                    pos = 0;
                    choice = false;
                    break;
                default:
                    System.out.println("MAUVAIS CHOIX");
                    break;
            }
        }
        return pos;
    }

    /**
     * Méthode pour afficher la liste des perso avec une ArrayList
     *
     * @param tab
     * @return un affichage de la liste des personnages
     */
    public static void displayArrayList(List tab) {
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
    public static void displayList(AbstractPersonnage[] tab) {
        System.out.println("Liste des personnages :");

        int i = 0;
        for (AbstractPersonnage var : tab) {
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
    public static boolean[] keepCreating(Scanner sc, boolean keepCreate, boolean keepAsking) {

        boolean[] temp = new boolean[2];

        System.out.println("Voulez vous créer un autre personnage ? ( 1 -> oui / 2 -> non ) ");
        String keepCreateChoice = sc.nextLine().toLowerCase();

        switch (keepCreateChoice) {
            case "1":
                temp[0] = true;
                temp[1] = false;
                break;
            case "2":
                temp[0] = false;
                temp[1] = false;
                break;
            default:
                System.out.println("!!! - Veuillez saisir une réponse valide ( 1 / 2 ) - !!!");
                break;
        }
        return temp;
    }

    public static class RandomBonus {
        private AbstractPersonnage player;
        private Scanner sc;
        private int pos;

        public RandomBonus(AbstractPersonnage player, Scanner sc, int pos) {
            this.player = player;
            this.sc = sc;
            this.pos = pos;
        }

        public int invoke() {
            Bonus randomBonus = Bonus.random();
            System.out.println("Vous êtes sur une case bonus !");
            System.out.println("Vous obtenez " + randomBonus.getName());
            System.out.println("Vous gagnez " + randomBonus.getPuissance() + " puissance " + randomBonus.getVie() + " points de vie");
            player.setVie(player.getVie() + randomBonus.getVie());
            player.setForce(player.getForce() + randomBonus.getPuissance());
            System.out.println("Appuyer sur Entrée pour continuer");

            sc.nextLine();
            pos++;
            return pos;
        }
    }
}