package flyweight;

import java.io.IOException;

public class FlyWeightDriver {
    public static void main(String[] args) throws IOException {

        TextDocument document = new TextDocument();

        String text1 = "Hello";
        String text2 = "World";
        String text3 = "CS";
        String text4 = "3560";

        // Variation 1: Arial, Red, 12
        for (int i = 0; i < text1.length(); i++) {
            document.addCharacter(text1.charAt(i), "Arial", "Red", 12);
        }

        // Variation 2: Calibri, Blue, 14
        for (int i = 0; i < text2.length(); i++) {
            document.addCharacter(text2.charAt(i), "Calibri", "Blue", 14);
        }

        // Variation 3: Verdana, Black, 16
        for (int i = 0; i < text3.length(); i++) {
            document.addCharacter(text3.charAt(i), "Verdana", "Black", 16);
        }

        // Variation 4: Arial, Blue, 12
        for (int i = 0; i < text4.length(); i++) {
            document.addCharacter(text4.charAt(i), "Arial", "Blue", 12);
        }

        // Display original document
        System.out.println("Original Document:");
        document.displayDocument();

        // Edit the formatting of the first character
        document.editCharacterStyle(0, "Verdana", "Black", 16);

        System.out.println("\nDocument After Editing:");
        document.displayDocument();

        // Save document to file
        document.saveToFile("document.txt");
        System.out.println("\nDocument saved to document.txt");

        // Load document into a new object
        TextDocument loadedDocument = new TextDocument();
        loadedDocument.loadFromFile("document.txt");

        System.out.println("\nLoaded Document:");
        loadedDocument.displayDocument();

        // Verfy Flyweight object sharing
        CharacterStyle style1 = CharacterStyleFactory.getStyle("Arial", "Red", 12);
        CharacterStyle style2 = CharacterStyleFactory.getStyle("Arial", "Red", 12);

        System.out.println("\nFlyweight Sharing Test:");
        System.out.println("Same style object: " + (style1 == style2));
    }
}
