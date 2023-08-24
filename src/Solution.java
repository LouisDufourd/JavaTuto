import clavier.In;
import entity.Entity;
import entity.Joueur;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        boolean boucle = true; //ici pour faire arrêter la boucle quand on veut
        Random rd = new Random(); //initialisation du générateur de nombres aléatoire
        Entity entity = new Entity(rd.nextInt(5,15), rd.nextInt(1,6)); //génère-les stats de l'entité aléatoirement
        System.out.println("Type your username");
        Joueur joueur = new Joueur(In.readString(), 20,rd.nextInt(2,5)); //génère-les dégât du joueur aléatoirement + demande le pseudo
        while (boucle) {
            //remplace %s par le nom du joueur
            System.out.printf("""
                    %s :
                        1 -> Attack
                        2 -> Pass
                        3 -> Stats
                    """, joueur.getName() //remplace %s par le nom du joueur (joueur.getName())
            ); //affichage du menu
            try {
                int choice = In.readInteger(); //lit l'option qu'a choisi le joueur
                switch (choice) {
                    case 1 -> { //ici le joueur choisi d'attaquer
                        boucle = playerAttack(joueur,entity);
                        if(boucle) { //on vérifie si la boucle va s'arrêter
                            boucle = entityAttack(joueur, entity); //si le joueur est mort, on retourne false sinon on retourne true (voir la fonction pour plus de précision)
                        }
                    }
                    case 2 -> boucle = entityAttack(joueur, entity); //ici le joueur passe son tour et la fonction entityAttack s'exécute

                    case 3 -> { //ici le joueur affiche ses stats
                        System.out.printf("""
                                
                                %1$s :
                                    Health : %2$d
                                    Damage : %3$d
                                %n""", joueur.getName(), joueur.getHealth(), joueur.getDamage());
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please type a number"); //on s'assure que l'utilisateur à bien tapper un nombre
            }
        }
    }

    /**
     * @param joueur le joueur qui se fait attaquer
     * @param entity l'entité qui attaque
     * @return retourne false si le joueur meurt sinon true
     */
    public static boolean entityAttack( Joueur joueur, Entity entity) {
        Random rd = new Random(); //crée un générateur de nombre aléatoire
        if (rd.nextInt(0,2) == 0) { //on génère un nombre aléatoire entre 0 et 1 et on regarde si c'est égal à 0.
            joueur.takeDamage(entity.getDamage()); // si c'est égal à 0 l'entité attaque
        }
        if (joueur.getHealth() <= 0) {
            System.out.println("You got defeated by the entity"); //on regarde si le joueur à plus
            return false; //retourne false si le joueur est mort
        }
        System.out.println(joueur.name + " is at " + joueur.getHealth() + "hp\n"); //affiche les points de vie du joueur
        return true;
    }
    public static boolean playerAttack(Joueur joueur, Entity entity) {
        entity.takeDamage(joueur.getDamage()); //l'entité reçoit des dégâts en fonction des damages du joueur
        if(entity.getHealth() <= 0) { //on vérifie si l'entité a encore des point de vie
            System.out.println("You defeat the entity"); //on affiche que l'entité est morte
            return false; //on stop la boucle
        }
        System.out.println("\nThe entity is at " + entity.getHealth() + "hp\n"); //on affiche les point de vie de l'entité si elle est en vie
        return true;
    }
}
