import clavier.In;

public class Main {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        System.out.println("Entrez votre nom d'utilisateur");
        String userName = In.readString();
        System.out.println("Entrez votre mots de passe");
        String passWord = In.readString();
        if(userName.equals(USERNAME) && passWord.equals(PASSWORD)) {
            System.out.println("Connexion");
        } else {
            System.out.println("Ce login est incorrect");
        }
    }
}
