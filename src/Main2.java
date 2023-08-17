import org.jetbrains.annotations.NotNull;

public class Main2 {
    public static void main(String[] args) {

    }
    public static void showTab(@NotNull byte[] bytes) {
        System.out.println("----------------------Affichage du tableau---------------------");
        System.out.print("{");
        for (int i = 0; i < bytes.length; i++) {
            String value = Integer.toString(bytes[i] & 0xFF, 2);
            if(value.length() < 8) {
                String _0 = new String();
                for (int j = 0; j < 8 - value.length(); j++) {
                    _0 += "0";
                }
                value = "0b" + _0 + value;
            }
            if(i != bytes.length - 1) {
                System.out.print(value + ",");
            } else {
                System.out.print(value);
            }
        }
        System.out.println("}");
        System.out.println("-----------------Fin de l'affichage du tableau-----------------");
    }
}
