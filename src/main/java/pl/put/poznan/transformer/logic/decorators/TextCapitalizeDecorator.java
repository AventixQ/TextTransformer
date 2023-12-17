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
 * The Capitalize class is a decorator that adds the functionality of changing the first letter of the text to uppercase, and the rest to lowercase.
 * It inherits from the TextDecorator class and implements the TextTransform interface.
 */
public class TextCapitalizeDecorator extends TextDecorator {
    private static Logger logger = LoggerFactory.getLogger(TextCapitalizeDecorator.class);

    /**
     * Constructor of the Capitalize class.
     *
     * @param textTransform An object implementing the TextTransform interface to be decorated.
     */
    public TextCapitalizeDecorator(TextTransform textTransform) {
        super(textTransform);
    }

    /**
     * Applies the transformation to the text, changing the first letter to uppercase and the rest to lowercase.
     *
     * @param text The text to which the transformation should be applied.
     * @return The transformed text.
     */
    @Override
    public String apply(String text) {
        String transformedText = super.apply(text);

        if (transformedText.length() > 0) {
            transformedText = transformedText.substring(0, 1).toUpperCase() + transformedText.substring(1).toLowerCase();
        }

        logger.debug(String.format("text: %s, capitalized: %s", text, transformedText));
        logger.info("Successfully capitalized!");
        return transformedText;
    }
}
