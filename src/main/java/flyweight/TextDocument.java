package flyweight;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;

public class TextDocument {
    private ArrayList<TextCharacter> characters = new ArrayList<>();

    public void addCharacter(char character, String font, String color, int size) {
        CharacterStyle style = CharacterStyleFactory.getStyle(font, color, size);
        TextCharacter textChar = new TextCharacter(character, style);
        characters.add(textChar);
    }

    public void displayDocument() {
        for (TextCharacter character: characters) {
            System.out.print(character.getCharacter());
        }
        System.out.println();
    }

    public void saveToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            for(TextCharacter character: characters) {

                CharacterStyle style = character.getStyle();

                writer.println(character.getCharacter() + "," + style.getFont()
                        + "," + style.getColor() + "," + style.getSize());
            }
        }
    }

    public void loadFromFile(String filename) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            characters.clear();

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                char character = parts[0].charAt(0);
                String font = parts[1];
                String color = parts[2];
                int size = Integer.parseInt(parts[3]);

                addCharacter(character, font, color, size);
            }
        }
    }

    public void editCharacterStyle(int index, String font, String color, int size) {
        if(index < 0 || index >= characters.size()) {
            System.out.println("Invalid char index.");
            return;
        }

        TextCharacter textChar = characters.get(index);

        CharacterStyle newStyle = CharacterStyleFactory.getStyle(font, color, size);

        textChar.setStyle(newStyle);
    }
}
