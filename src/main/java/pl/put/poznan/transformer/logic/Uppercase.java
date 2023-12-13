package pl.put.poznan.transformer.logic;

/**
 * Klasa Uppercase jest dekoratorem, który dodaje funkcjonalność zamiany wszystkich liter tekstu na duże litery.
 * Dziedziczy ona po klasie TextDecorator i implementuje interfejs TextTransform.
 */
public class Uppercase extends TextDecorator {

    /**
     * Konstruktor klasy Uppercase.
     *
     * @param textTransform Obiekt implementujący interfejs TextTransform, który ma zostać udekorowany.
     */
    public Uppercase(TextTransform textTransform) {
        super(textTransform);
    }

    /**
     * Zastosowuje transformację do tekstu, zamieniając wszystkie litery na duże.
     *
     * @param text Tekst, do którego ma zostać zastosowana transformacja.
     * @return Przekształcony tekst.
     */
    @Override
    public String apply(String text) {
        String transformedText = super.apply(text);
        return transformedText.toUpperCase();
    }
}