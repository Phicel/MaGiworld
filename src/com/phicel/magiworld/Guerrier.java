package com.phicel.magiworld;

    public class Guerrier extends Player {

    protected Guerrier(int numPlayer, int strength, int agility, int intelligence) {
        super(numPlayer, strength, agility, intelligence);
        type = "Guerrier";
    }

    // actions du guerrier
    protected String play(int choix) {
        String texte = "";
        switch (choix) {
            case 1:
                enemy.subsLife(strength);
                texte = texte + namePlayer + " utilise Coup d'épée et inflige " + strength + " de dégâts";
                break;
            case 2:
                enemy.subsLife((strength * 2));
                life = life - strength / 2;
                texte = texte + namePlayer + " utilise Coup de rage, inflige " + (strength * 2) + " de dégâts et perd " + (strength / 2) + " de vitalité";
                break;
            default:
                break;
        }

        if (life > 0) {
            return texte;                   // retour texte du resultat
        }
        else {
            return "Le " + namePlayer + " n'a plus de vie, il a perdu !";
        }

    }
}

