import clavier.In;
import entity.Entity;
import entity.Joueur;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Entrez votre pseudo :");
        Joueur joueur = new Joueur(In.readString(), 20, 3);
        Entity entity = new Entity(10, 2);
        while (joueur.getHealth() > 0 && entity.getHealth() > 0) {
            System.out.println("Que doit faire " + joueur.getName() + " ?\n" +
                    "\n1 -> attaquer" +
                    "\n2 -> ne rien faire"
            );
            int choix = In.readInteger();
            switch (choix) {
                case 1 -> {
                    entity.takeDamage(joueur.getDamage());
                    System.out.println("L'entité se prend " + joueur.getDamage() + " dégâts et est à " + entity.getHealth() + " points de vie\n");
                }
                case 2 -> {
                    System.out.println(joueur.getName() + " ne fait rien\n");
                }
            }
            Random rd = new Random();
            int randomNumber = rd.nextInt(0, 2); //génère un entier entre 0 et 1
            if (randomNumber == 0) {
                joueur.takeDamage(entity.getDamage());
                System.out.println(joueur.getName() + " s'est mangé " + entity.getDamage() + " dégâts et est à " + joueur.getHealth() + " Points de vie\n");
            } else {
                System.out.println("L'entité ne fait rien\n");
            }
            if (joueur.getHealth() <= 0) {
                System.out.println(joueur.getName() + " est décédé\n");
            } else if (entity.getHealth() <= 0) {
                System.out.println(joueur.getName() + " est victorieux\n");
            }
        }
    }
}