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
 * Klasa Capitalize jest dekoratorem, który dodaje funkcjonalność zmiany pierwszej litery tekstu na dużą, a resztę na małe litery.
 * Dziedziczy ona po klasie TextDecorator i implementuje interfejs TextTransform.
 */
public class TextCapitalizeDecorator extends TextDecorator {
    private static Logger logger = LoggerFactory.getLogger(TextCapitalizeDecorator.class);
    /**
     * Konstruktor klasy Capitalize.
     *
     * @param textTransform Obiekt implementujący interfejs TextTransform, który ma zostać udekorowany.
     */
    public TextCapitalizeDecorator(TextTransform textTransform) {
        super(textTransform);
    }

    /**
     * Zastosowuje transformację do tekstu, zmieniając pierwszą literę na dużą, a resztę na małe litery.
     *
     * @param text Tekst, do którego ma zostać zastosowana transformacja.
     * @return Przekształcony tekst.
     */
    @Override
    public String apply(String text) {
        String transformedText = super.apply(text);

        if (transformedText.length() > 0) {
            transformedText = transformedText.substring(0, 1).toUpperCase() + transformedText.substring(1).toLowerCase();
        }

        logger.debug(String.format("text: %s, capitalized: %s",text, transformedText));
        logger.info("Successfully capitlized!");
        return transformedText;
    }
}