import clavier.In;

public class Main {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        System.out.println("Entrez votre nom d'utilisateur");
        String userName = In.readString();
        if (userName.equals(USERNAME)) {
            System.out.println("Entrez votre mots de passe");
            String passWord = In.readString();
            if (passWord.equals(PASSWORD)) {
                System.out.println("Connexion");
            } else {
                System.out.println("Mot de passe erroné");
            }
        } else {
            System.out.println("Cet utilisateur n'existe pas");
        }
    }
}
