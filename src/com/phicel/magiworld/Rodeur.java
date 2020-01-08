package com.phicel.magiworld;

public class Rodeur extends Player {

    public Rodeur(int numPlayer, int strength, int agility, int intelligence) {
        super(numPlayer, strength, agility, intelligence);
        type = "Rôdeur";
    }

    // actions du rodeur
    protected String play(int choix) {
        String texte = "";
        switch (choix) {
            case 1:
                enemy.subsLife(agility);             // on enleve des pts de vie au joueur(adversaire)
                texte = texte + namePlayer + " utilise Tir à l'Arc et inflige " + agility + " de dégâts";
                break;
            case 2:
                agility = agility + (level / 2);
                texte = texte + namePlayer + " utilise Concentration et gagne " + (level / 2) + " d'agilité";
                break;
            default:
                break;
        }
        return texte;
    }
}
