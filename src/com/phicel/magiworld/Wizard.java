package com.phicel.magiworld;

public class Wizard extends Player {

    private int lifeMax;

    public Wizard(int numPlayer, int strength, int agility, int intelligence) {
        super(numPlayer, strength, agility, intelligence);
        lifeMax = life;
        type = "Mage";
    }

    // actions du mage
    protected String play(int choice) {
        String texte = "";
        switch (choice) {
            case 1:
                enemy.subsLife(intelligence);
                texte = texte + namePlayer + " utilise boule de feu et inflige " + intelligence + " de dégâts";
                break;
            case 2:
                //Soin
                texte = texte + namePlayer + " utilise Soin et gagne ";
                if ((intelligence * 2) + life > lifeMax) {
                    texte = texte + (lifeMax - life) + " de vitalité"; // Vie = VieMax si dépasse
                    life = lifeMax;
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
