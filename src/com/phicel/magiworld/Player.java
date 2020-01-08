package com.phicel.magiworld;

     public abstract class Player {

        protected String namePlayer, type;
        protected int level, life, strength, agility, intelligence;
        protected Player enemy;

         Player(int numPlayer, int strength, int agility, int intelligence) {
             namePlayer = "Joueur " + numPlayer;
            level = strength + agility + intelligence;
            this.strength = strength;
            this.agility = agility;
            this.intelligence = intelligence;
            life = level * 5;
        }

        /* méthode action du joueur - argument choix en parametre
         si la vie > 0 le choix d'un type d'attaque est selectionné (choix 1 ou 2)
         fonction jouer de la sous-classe indiquée - type d'attaque different
        */
        public void actionPlayer() {
            int choice;
            if (life > 0) {
                do {
                    System.out.println(namePlayer + " (" + life + " vitalité), veuillez choisir votre action (1 : attaque basique, 2 : attaque spéciale)");
                    choice = Main.enterChoice(1 ,2);
                    if (choice != 1 && choice != 2) System.out.println("Entrez une valeur correcte !");
                } while (choice != 1 && choice != 2);

                System.out.println(this.play(choice));                  // lancement de l'action choisie + affichage

                if (life <= 0) return;
                this.enemy.actionPlayer();                         // selection de l'adversaire du joueur en cours
            }

            else {
                System.out.println("Le " + namePlayer + " à perdu !");   // sortie de la boucle de jeu
            }
        }

        protected void subsLife(int ptsToSub) { // on retire de la vie
            life = life - ptsToSub;
        }

        protected abstract String play(int choix);

        public void selectEnemy(Player enemy) { //selection de l'adversaire du joueur en cours
            this.enemy = enemy;
        }

        public String whoAmI() {
            return "Je suis le " + type + ", " + namePlayer + ", niveau " + level + ", je possède " + life + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence.";
        }

    }

