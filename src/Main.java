import clavier.In;

public class Main {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        System.out.println(
                "m -> Bonjour" +
                "\np -> maison" +
                "\nw -> pirate"
        );
         String lettre = In.readString();
         switch (lettre) {
             case "m":
                 System.out.println("Bonjour");
                 break;
             case "p":
                 System.out.println("maison");
                 break;
             case "w":
                 System.out.println("pirate");
                 break;
         }
    }
}
