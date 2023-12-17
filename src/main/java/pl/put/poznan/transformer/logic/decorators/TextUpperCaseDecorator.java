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
 * The Uppercase class is a decorator that adds the functionality of converting all letters in the text to uppercase.
 * It inherits from the TextDecorator class and implements the TextTransform interface.
 */
public class TextUpperCaseDecorator extends TextDecorator {
    private static Logger logger = LoggerFactory.getLogger(TextUpperCaseDecorator.class);

    /**
     * Constructor of the Uppercase class.
     *
     * @param textTransform An object implementing the TextTransform interface to be decorated.
     */
    public TextUpperCaseDecorator(TextTransform textTransform) {
        super(textTransform);
    }

    /**
     * Applies the transformation to the text, converting all letters to uppercase.
     *
     * @param text The text to which the transformation should be applied.
     * @return The transformed text.
     */
    @Override
    public String apply(String text) {
        String transformedText = super.apply(text);
        logger.debug(String.format("text: %s, uppercase: %s", text, transformedText.toUpperCase()));
        logger.info("Successfully converted to uppercase!");
        return transformedText.toUpperCase();
    }
}
