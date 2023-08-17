public class Eleve {
    private String nom;
    private String prenom;
    private double note;


    /**
     * @param nom     Le nom de l'élève
     * @param prenom  Le prénom de l'élève
     * @param note    La note de l'élève
     * @return        Retourne l'élève
     */
    public Eleve(String nom, String prenom, double note) {
        this.nom = nom;
        this.prenom = prenom;
        this.note = note;
    }

    /**
     * @return Le nom de l'élève
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return Le prénom de l'élève
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return La note de l'élève
     */
    public double getNote() {
        return note;
    }

    /**
     *
     * @param note la note que l'on veut donner à l'élève
     */
    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Nom : " + this.nom + "\nPrénom : " + this.prenom + "\nNote : " + this.note;
    }
}
