import clavier.In;
import org.jetbrains.annotations.NotNull;

import javax.lang.model.element.Element;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class aClass = new Class();
        aClass.showClass();
    }

    public static void printTab(@NotNull List<Eleve> list) {
        System.out.println("-----------------Affichage du tableau-----------------");
        int maxLengthNom = 0;
        int maxLengthPrenom = 0;
        int maxLengthNotes = 0;
        for (Eleve eleve: list) {
            if(maxLengthNom < eleve.getNom().length()) {
                maxLengthNom = eleve.getNom().length();
            }
            if(maxLengthPrenom < eleve.getPrenom().length()) {
                maxLengthPrenom = eleve.getPrenom().length();
            }
            if(maxLengthNotes < String.valueOf(eleve.getNote()).length()) {
                maxLengthNotes = String.valueOf(eleve.getNote()).length();
            }
        }
        for (Eleve eleve : list) {
            System.out.print("| ");
            System.out.print(eleve.getNom());
            for (int i = 0; i < maxLengthNom - eleve.getNom().length(); i++) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            System.out.print(eleve.getPrenom());
            for (int i = 0; i < maxLengthPrenom - eleve.getPrenom().length(); i++) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            System.out.print(eleve.getNote());
            for (int i = 0; i < maxLengthNotes - String.valueOf(eleve.getNote()).length(); i++) {
                System.out.print(" ");
            }
            System.out.print(" |\n");
        }
        System.out.println("-----------------Fin Affichage du tableau-----------------");
    }

    public static void sort(@NotNull List<Eleve> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < (list.size() - 1); j++) {
                if(list.get(j-1).getNote() > list.get(j).getNote()) {
                    Eleve eleve = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, eleve);
                }
            }
        }
    }
}