/**
 * 2023-12-13
 * L13-delta
 */

package pl.put.poznan.transformer.logic.decorators;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

/**
 * Klasa Uppercase jest dekoratorem, który dodaje funkcjonalność zamiany wszystkich liter tekstu na duże litery.
 * Dziedziczy ona po klasie TextDecorator i implementuje interfejs TextTransform.
 */
public class TextUpperCaseDecorator extends TextDecorator {
    private static Logger logger = LoggerFactory.getLogger(TextUpperCaseDecorator.class);
    /**
     * Konstruktor klasy Uppercase.
     *
     * @param textTransform Obiekt implementujący interfejs TextTransform, który ma zostać udekorowany.
     */
    public TextUpperCaseDecorator(TextTransform textTransform) {
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
        logger.debug(String.format("text: %s, uppercase: %s",text, transformedText.toUpperCase()));
        logger.info("Successfully converted to uppercase!");
        return transformedText.toUpperCase();
    }
}
