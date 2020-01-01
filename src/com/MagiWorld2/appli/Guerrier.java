package com.MagiWorld2.appli;

    public class Guerrier extends Joueur {

    protected Guerrier(int numJoueur, int force, int agilite, int intelligence) {
        super(numJoueur, force, agilite, intelligence);
        type = "Guerrier";
    }

    // actions du guerrier
    protected String jouer(int choix) {
        String texte = "";
        switch (choix) {
            case 1:
                adversaire.enleverVie(force);
                texte = texte + nomJoueur + " utilise Coup d'épée et inflige " + force + " de dégâts";
                break;
            case 2:
                adversaire.enleverVie((force * 2));
                vie = vie - force / 2;
                texte = texte + nomJoueur + " utilise Coup de rage, inflige " + (force * 2) + " de dégâts et perd " + (force / 2) + " de vitalité";
                break;
            default:
                break;
        }

        if (vie > 0) {
            return texte;                   // retour texte du resultat
        }
        else {
            return "Le " + nomJoueur + " n'a plus de vie, il a perdu !";
        }

    }
}

