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
 * The Lowercase class is a decorator that adds the functionality of converting all letters in the text to lowercase.
 * It inherits from the TextDecorator class and implements the TextTransform interface.
 */
public class TextLowerCaseDecorator extends TextDecorator {
    private static Logger logger = LoggerFactory.getLogger(TextLowerCaseDecorator.class);

    /**
     * Constructor of the Lowercase class.
     *
     * @param textTransform An object implementing the TextTransform interface to be decorated.
     */
    public TextLowerCaseDecorator(TextTransform textTransform) {
        super(textTransform);
    }

    /**
     * Applies the transformation to the text, converting all letters to lowercase.
     *
     * @param text The text to which the transformation should be applied.
     * @return The transformed text.
     */
    @Override
    public String apply(String text) {
        String transformedText = super.apply(text);

        logger.debug(String.format("text: %s, lowercase: %s", text, transformedText.toLowerCase()));
        logger.info("Successfully converted to lowercase!");
        return transformedText.toLowerCase();
    }
}
