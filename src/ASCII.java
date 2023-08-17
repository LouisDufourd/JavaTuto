import java.util.HashMap;
import java.util.Map;

public class ASCII {
    private final Map<Integer, Character> VAL_TO_ASCII = new HashMap<>();
    private final Map<Character, Integer> ASCII_TO_VAL = new HashMap<>();

    public ASCII() {
        for (int i = 0; i < 128; i++) {
            VAL_TO_ASCII.put(i,(char) i);
            ASCII_TO_VAL.put((char) i, i);
        }
    }

    public char getChar(int hexValue) {
        return VAL_TO_ASCII.get(hexValue);
    }

    public int getValue(char c) {
        return ASCII_TO_VAL.get(c);
    }
}
