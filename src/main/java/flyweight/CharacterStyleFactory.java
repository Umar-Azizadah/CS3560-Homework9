package flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterStyleFactory {
    private static final Map<String, CharacterStyle> styles = new HashMap<>();

    public static CharacterStyle getStyle(String font, String color, int size) {
        String key = font + "-" + color + "-" + size;

        if (!styles.containsKey(key)) {
            styles.put(key, new CharacterStyle(font, color, size));
        }

        return styles.get(key);
    }
}
