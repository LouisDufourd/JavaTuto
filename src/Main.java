import clavier.In;
import org.jetbrains.annotations.NotNull;

import javax.lang.model.element.Element;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Main {

    //public static final byte[] message = {0b01001100,0b01100001,0b00100000,0b01110110,0b01101001,0b01100101,0b00100000,0b01100101,0b01110011,0b01110100,0b00100000,0b01110101,0b01101110,0b00100000,0b01101100,0b01101111,0b01101110,0b01100111,0b00100000,0b01100110,0b01101100,0b01100101,0b01110101,0b01110110,0b01100101,0b00100000,0b01110100,0b01110010,0b01100001,0b01101110,0b01110001,0b01110101,0b01101001,0b01101100,0b01101100,0b01100101};
    public static final byte[] message = {0b01010011,0b01100001,0b01101100,0b01110101,0b01110100};
    public static void main(String[] args) {
        ASCII ascii = new ASCII();
        for(int i = 0; i < message.length; i++) {
            System.out.print(ascii.getChar(message[i]));
        }
        System.out.println();
        System.out.println("Entrez un message");
        showTab(In.readString().getBytes());
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