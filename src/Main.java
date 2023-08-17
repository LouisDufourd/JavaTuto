import clavier.In;
import org.jetbrains.annotations.NotNull;

import javax.lang.model.element.Element;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Main {

    //public static final byte[] message = {0b01001100,0b01100001,0b00100000,0b01110110,0b01101001,0b01100101,0b00100000,0b01100101,0b01110011,0b01110100,0b00100000,0b01110101,0b01101110,0b00100000,0b01101100,0b01101111,0b01101110,0b01100111,0b00100000,0b01100110,0b01101100,0b01100101,0b01110101,0b01110110,0b01100101,0b00100000,0b01110100,0b01110010,0b01100001,0b01101110,0b01110001,0b01110101,0b01101001,0b01101100,0b01101100,0b01100101};
    //public static final byte[] message = {0b01010011,0b01100001,0b01101100,0b01110101,0b01110100};
    public static final String CHEMIN = "message.bin";

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        boolean stopBoucleWhenFalse = true;
        while(stopBoucleWhenFalse) {
            try {
                System.out.println(
                        "1 -> Écrire"
                                + "\n2 -> Lire"
                                + "\n3 -> End"
                );
                String nombre = In.readString();
                switch (nombre) {
                    case "1" -> {
                        ReadWriteFile.writeBinaryFile(CHEMIN, In.readString().getBytes());
                    }
                    case "2" -> {
                        byte[] message = ReadWriteFile.readBinaryFile(CHEMIN);
                        System.out.println(new String(message));
                    }
                    case "3" -> {
                        stopBoucleWhenFalse = false;
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
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