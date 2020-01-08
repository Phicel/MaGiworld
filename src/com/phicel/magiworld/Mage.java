package com.phicel.magiworld;

public class Mage extends Player {

    private int vieMax;

    public Mage(int numPlayer, int strength, int agility, int intelligence) {
        super(numPlayer, strength, agility, intelligence);
        vieMax = life;
        type = "Mage";
    }

    // actions du mage
    protected String play(int choix) {
        String texte = "";
        switch (choix) {
            case 1:
                enemy.subsLife(intelligence);
                texte = texte + namePlayer + " utilise boule de feu et inflige " + intelligence + " de dégâts";
                break;
            case 2:
                //Soin
                texte = texte + namePlayer + " utilise Soin et gagne ";
                if ((intelligence * 2) + life > vieMax) {
                    texte = texte + (vieMax - life) + " de vitalité"; // Vie = VieMax si dépasse
                    life = vieMax;
                }
                else {
                    texte = texte + (intelligence * 2) + " de vitalité";
                    life = life + (intelligence * 2);
                }
                break;
            default:
                break;
        }
        return texte;
    }
}
