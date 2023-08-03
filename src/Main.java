import clavier.In;

public class Main {

    public static void main(String[] args) {

        int valeur = 0;
        while (valeur != 1 && valeur != 2 && valeur != 3) {
            System.out.println(
                    "1 -> Maison\n" +
                            "2 -> Battaille\n" +
                            "3 -> Plag > Jesterio²"
            );
            valeur = In.readInteger();
            switch (valeur) {
                case 1:
                    System.out.println("Maison");
                    break;
                case 2:
                    System.out.println("Battaille");
                    break;
                case 3:
                    System.out.println("ntm");
                    break;
            }
        }
    }
}
