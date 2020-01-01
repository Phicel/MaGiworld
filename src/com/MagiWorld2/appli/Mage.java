package com.MagiWorld2.appli;

public class Mage extends Joueur {

    private int vieMax;

    public Mage(int numJoueur, int force, int agilite, int intelligence) {
        super(numJoueur, force, agilite, intelligence);
        vieMax = vie;
        type = "Mage";
    }

    // actions du mage
    protected String jouer(int choix) {
        String texte = "";
        switch (choix) {
            case 1:
                adversaire.enleverVie(intelligence);
                texte = texte + nomJoueur + " utilise boule de feu et inflige " + intelligence + " de dégâts";
                break;
            case 2:
                //Soin
                texte = texte + nomJoueur + " utilise Soin et gagne ";
                if ((intelligence * 2) + vie > vieMax) {
                    texte = texte + (vieMax - vie) + " de vitalité"; // Vie = VieMax si dépasse
                    vie = vieMax;
                }
                else {
                    texte = texte + (intelligence * 2) + " de vitalité";
                    vie = vie + (intelligence * 2);
                }
                break;
            default:
                break;
        }
        return texte;
    }
}
