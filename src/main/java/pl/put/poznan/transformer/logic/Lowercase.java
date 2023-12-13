/**
 * 2023-12-13
 * L13-delta
 */

package pl.put.poznan.transformer.logic;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import pl.put.poznan.transformer.logic.decorators.TextExpandAbbreviationDecorator;

/**
 * Klasa Lowercase jest dekoratorem, który dodaje funkcjonalność zamiany wszystkich liter tekstu na małe litery.
 * Dziedziczy ona po klasie TextDecorator i implementuje interfejs TextTransform.
 */
public class Lowercase extends TextDecorator {
    private static Logger logger = LoggerFactory.getLogger(Lowercase.class);
    /**
     * Konstruktor klasy Lowercase.
     *
     * @param textTransform Obiekt implementujący interfejs TextTransform, który ma zostać udekorowany.
     */
    public Lowercase(TextTransform textTransform) {
        super(textTransform);
    }

    /**
     * Zastosowuje transformację do tekstu, zamieniając wszystkie litery na małe.
     *
     * @param text Tekst, do którego ma zostać zastosowana transformacja.
     * @return Przekształcony tekst.
     */
    @Override
    public String apply(String text) {
        String transformedText = super.apply(text);

        logger.debug(String.format("text: %s, lowercase: %s",text, transformedText.toLowerCase()));
        logger.info("Successfully converted to lowercase!");
        return transformedText.toLowerCase();
    }
}