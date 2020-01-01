package com.MagiWorld2.appli;

     public abstract class Joueur {

        protected String nomJoueur, type;
        protected int niveau, vie, force, agilite, intelligence;
        protected Joueur adversaire;

        Joueur(int numJoueur, int force, int agilite, int intelligence) {
            nomJoueur = "Joueur " + numJoueur;
            niveau = force + agilite + intelligence;
            this.force = force;
            this.agilite = agilite;
            this.intelligence = intelligence;
            vie = niveau * 5;
        }

        public void actionJoueur() {
            int choix;
            if (vie > 0) {
                do {
                    System.out.println(nomJoueur + " (" + vie + " vitalité), veuillez choisir votre action (1 : attaque basique, 2 : attaque spéciale)");
                    choix = Main.entreeChoix(1 ,2);
                    if (choix != 1 && choix != 2) System.out.println("Entrez une valeur correcte !");
                } while (choix != 1 && choix != 2);

                System.out.println(this.jouer(choix));                  // lancement de l'action choisie + affichage

                if (vie <= 0) return;
                this.adversaire.actionJoueur();                         // selection de l'adversaire du joueur en cours
            }

            else {
                System.out.println("Le " + nomJoueur + " à perdu !");   // sortie de la boucle de jeu
            }
        }

        protected void enleverVie(int pointsAEnlever) { // on retire de la vie
            vie = vie - pointsAEnlever;
        }

        protected abstract String jouer(int choix);

        public void selectionAdversaire(Joueur adversaire) { //selection de l'adversaire du joueur en cours
            this.adversaire = adversaire;
        }

        public String quiJeSuis() {
            return "Je suis le " + type + ", " + nomJoueur + ", niveau " + niveau + ", je possède " + vie + " de vitalité, " + force + " de force, " + agilite + " d'agilité et " + intelligence + " d'intelligence.";
        }

    }

