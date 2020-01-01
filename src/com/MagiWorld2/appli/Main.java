package com.MagiWorld2.appli;

        import java.util.ArrayList;
        import java.util.InputMismatchException;
        import java.util.Scanner;

/**
 * @MaGiworld_v2.0
 * @phicel
 */
public class Main {

    public static void main(String[] args) {
        int numJoueur = 1;

        /*
        ArrayList al = new ArrayList();
        al.add(new Guerrier(numJoueur, 10, 10, 6));
        al.add(new Guerrier(numJoueur+1, 12, 11, 8));
        al.add(new Mage(numJoueur+2, 6, 12, 20));
        al.add(new Rodeur(numJoueur+3, 8, 18, 12));
        //new Guerrier(numJoueur, 10, 10, 6);
        //new Guerrier(numJoueur+1, 12, 11, 8);
        //new Mage(numJoueur+2, 6, 12, 20);
        //new Rodeur(numJoueur+3, 8, 18, 12);
        System.out.println("donnée à l'indice " + 1 + " = " + al.get(1));
        //al.get(1);
        */

        Joueur joueur1 = creationJoueur(numJoueur);         // on cree le joueur 1
        System.out.println(joueur1.quiJeSuis());            // le perso du joueur1 parle
        numJoueur++;                                        // numJoueur = 2

        Joueur joueur2 = creationJoueur(numJoueur);         // on cree le joueur 2
        System.out.println(joueur2.quiJeSuis());            // le perso du joueur2 parle

        joueur1.selectionAdversaire(joueur2);               // Selection de l'ennemi du joueur1 en cours
        joueur2.selectionAdversaire(joueur1);               // Selection de l'ennemi du joueur2 en cours

        joueur1.actionJoueur();                             // Lancement de la boucle de jeu

    }

    private static Joueur creationJoueur(int numJoueur) {
        Joueur joueur;                                      // creation d'un joueur (numJoueur)
        int type, niveau, force, agilite, intelligence;

        System.out.println("Création du perso " + numJoueur);
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        type = entreeChoix(1, 3);

        do {
            System.out.println("Niveau du personnage ?");
            niveau = entreeChoix(1, 100);

            System.out.println("Force du personnage ?");
            force = entreeChoix(0, 100);

            System.out.println("Agilité du personnage ?");
            agilite = entreeChoix(0, 100);

            System.out.println("Intelligence du personnage ?");
            intelligence = entreeChoix(0, 100);

            if (force + agilite + intelligence != niveau) {
                System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
            }
        } while (force + agilite + intelligence != niveau);

        switch (type) {                                     // creation du type de perso en fonction du choix
            case 1:
                joueur = new Guerrier(numJoueur, force, agilite, intelligence);
                break;
            case 2:
                joueur = new Rodeur(numJoueur, force, agilite, intelligence);
                break;
            case 3:
                joueur = new Mage(numJoueur, force, agilite, intelligence);
                break;
            default:
                joueur = new Mage(numJoueur, force, agilite, intelligence);
                break;
        }
        return joueur;                                      // retour du joueur crée
    }

    public static int entreeChoix(int min, int max) {
        int choix;
        Scanner scan1 = new Scanner(System.in);
        do {
            choix = 0;
            try {
                choix = scan1.nextInt();
            }

            catch (InputMismatchException e) {
                scan1.next();
            }

            if ((choix < min) || (choix > max)) {
                System.out.println("Recommencez svp en entrant un choix compris entre " + min + " et " + max);
            }

        } while ((choix < min) || (choix > max));
        return choix;
    }


}
