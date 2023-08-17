import java.util.ArrayList;

public class Class {
    private final ArrayList<Eleve> CURRENT_CLASS = new ArrayList<>();

    private double moyenne;

    public Class() {
        CURRENT_CLASS.add(new Eleve("COX", "Joshua", -1.0));
        CURRENT_CLASS.add(new Eleve("de MONTAZAC", "Donatien", -1.0));
        CURRENT_CLASS.add(new Eleve("CROUTE", "Antoine", -1.0));
        CURRENT_CLASS.add(new Eleve("CROUTE", "Daniel", -1.0));
        CURRENT_CLASS.add(new Eleve("HELLMAN", "Lucy", -1.0));
        CURRENT_CLASS.add(new Eleve("PICHON", "Gérard", -1.0));
        CURRENT_CLASS.add(new Eleve("LOGAN", "Twain", -1.0));
        CURRENT_CLASS.add(new Eleve("JOHNSON", "Lenny", -1.0));
        CURRENT_CLASS.add(new Eleve("RODRIGUEZ", "Miguel", -1.0));
        CURRENT_CLASS.add(new Eleve("MONNAY", "Johnny", -1.0));
        CURRENT_CLASS.add(new Eleve("BOID", "Bill", -1.0));
        CURRENT_CLASS.add(new Eleve("KUCK", "Francis", -1.0));
        CURRENT_CLASS.add(new Eleve("", "Le Iench", -1.0));
        moyenne = 0.0;
    }

    public void calculateMoy() {
        double sum = 0.0;
        for (Eleve eleve: CURRENT_CLASS) {
            sum += eleve.getNote();
        }
        moyenne = sum/CURRENT_CLASS.size();
    }

    public void setNotesToAStudent(double notes, int index) throws ArrayIndexOutOfBoundsException
    {
        CURRENT_CLASS.get(index).setNote(notes);
    }

    public void showClass() {
        int maxLengthNom = 0;
        int maxLengthPrenom = 0;
        int maxLengthNotes = 0;
        for (Eleve eleve: CURRENT_CLASS) {
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
        for (Eleve eleve : CURRENT_CLASS) {
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
    }
}
