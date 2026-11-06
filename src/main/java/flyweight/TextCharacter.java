package flyweight;

public class TextCharacter {
    private char character;
    private CharacterStyle style;

    public TextCharacter(char character, CharacterStyle style) {
        this.character = character;
        this.style = style;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterStyle getStyle() {
        return style;
    }

    public void setStyle(CharacterStyle style) {
        this.style = style;
    }
}
