package com.MagiWorld2.appli;

public class Rodeur extends Joueur {

    public Rodeur(int numJoueur, int force, int agilite, int intelligence) {
        super(numJoueur, force, agilite, intelligence);
        type = "Rôdeur";
    }

    // actions du rodeur
    protected String jouer(int choix) {
        String texte = "";
        switch (choix) {
            case 1:
                adversaire.enleverVie(agilite);             // on enleve des pts de vie au joueur(adversaire)
                texte = texte + nomJoueur + " utilise Tir à l'Arc et inflige " + agilite + " de dégâts";
                break;
            case 2:
                agilite = agilite + (niveau / 2);
                texte = texte + nomJoueur + " utilise Concentration et gagne " + (niveau / 2) + " d'agilité";
                break;
            default:
                break;
        }
        return texte;
    }
}
