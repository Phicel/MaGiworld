package com.phicel.magiworld;

        import java.util.InputMismatchException;
        import java.util.Scanner;


/**
 * @MaGiworld_le_combat_epique_!
 * @phicel
 */
public class Main {

    public static void main(String[] args) {
        int numPlayer = 1;


        Player player1 = createPlayer(numPlayer);         // on cree le joueur 1
        System.out.println(player1.whoAmI());            // le perso du joueur1 parle
        numPlayer++;                                        // numJoueur = 2

        Player player2 = createPlayer(numPlayer);         // on cree le joueur 2
        System.out.println(player2.whoAmI());            // le perso du joueur2 parle

        player1.selectEnemy(player2);               // Selection de l'ennemi du joueur1 en cours
        player2.selectEnemy(player1);               // Selection de l'ennemi du joueur2 en cours

        player1.actionPlayer();                             // Lancement de la boucle de jeu

    }

    private static Player createPlayer(int numPlayer) {
        Player player;                                      // creation d'un joueur (numJoueur)
        int type, level, strength, agility, intelligence;

        System.out.println("Création du perso " + numPlayer);
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        type = enterChoice(1, 3);

        do {
            System.out.println("Niveau du personnage ?");
            level = enterChoice(1, 100);

            System.out.println("Force du personnage ?");
            strength = enterChoice(0, 100);

            System.out.println("Agilité du personnage ?");
            agility = enterChoice(0, 100);

            System.out.println("Intelligence du personnage ?");
            intelligence = enterChoice(0, 100);

            if (strength + agility + intelligence != level) {
                System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
            }
        } while (strength + agility + intelligence != level);

        switch (type) {                                     // creation du type de perso en fonction du choix
            case 1:
                player = new Guerrier(numPlayer, strength, agility, intelligence);
                break;
            case 2:
                player = new Rodeur(numPlayer, strength, agility, intelligence);
                break;
            case 3:
                player = new Mage(numPlayer, strength, agility, intelligence);
                break;
            default:
                player = new Mage(numPlayer, strength, agility, intelligence);
                break;
        }
        return player;                                      // retour du joueur crée
    }

    public static int enterChoice(int min, int max) {
        int choice;
        Scanner scan1 = new Scanner(System.in);
        do {
            choice = 0;
            try {
                choice = scan1.nextInt();
            }

            catch (InputMismatchException e) {
                scan1.next();
            }

            if ((choice < min) || (choice > max)) {
                System.out.println("Recommencez svp en entrant un choix compris entre " + min + " et " + max);
            }

        } while ((choice < min) || (choice > max));
        return choice;
    }


}
