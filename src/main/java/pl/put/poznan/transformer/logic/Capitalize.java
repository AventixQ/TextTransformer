package pl.put.poznan.transformer.logic;

public class Capitalize extends TextDecorator {

    public Capitalize(TextTransform textTransform) {
        super(textTransform);
    }

    @Override
    public String apply(String text) {
        String transformedText = super.apply(text);
        // Sprawdzamy, czy tekst nie jest pusty
        if (transformedText.length() > 0) {
            // Zamieniamy pierwszą literę na dużą, a resztę na małe litery
            transformedText = transformedText.substring(0, 1).toUpperCase() + transformedText.substring(1).toLowerCase();
        }
        return transformedText;
    }
}