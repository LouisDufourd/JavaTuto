import clavier.In;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Eleve> eleves = new ArrayList<>();
        System.out.println(eleves.size());
        double moy;
        Eleve eleve;
        double sum = 0.0;
        while(true) {
            System.out.println("Entrée le nom de l'élève");
            String nom = In.readString();
            System.out.println("Entrée le prénom de l'élève");
            String prenom = In.readString();
            if(nom.equalsIgnoreCase("end") || prenom.equalsIgnoreCase("end")) {
                break;
            } else {
                try {
                    System.out.println("Entrée la note de l'élève");
                    double note = In.readDouble();
                    sum = sum + note;
                    eleves.add(new Eleve(nom,prenom,note));
                }
                catch(Exception e) {
                    System.out.println("Veuillez entrer une note.");
                    break;
                }
            }
        }
        System.out.println("-----------------Affichage du tableau---------------------");
        printTab(eleves);
        System.out.println("-----------------Fin Affichage du tableau---------------------");
        moy = sum / eleves.size();
        System.out.println("Taille du tableau " + eleves.size());
        System.out.println("Moyenne : " + moy);
    }

    public static void printTab(@NotNull ArrayList<Eleve> eleves) {
        for (int i = 0; i < eleves.size(); i++) {
            System.out.println(eleves.get(i));
            if(!((i + 1) >= eleves.size())) {
                System.out.println();
            }
        }
    }
}