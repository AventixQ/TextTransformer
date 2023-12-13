/**
 * 2023-12-13
 * L13-delta
 */

package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
/**
 * This is class for inverting the text.
 */
public class TextInverseDecorator extends TextDecorator {
    private static Logger logger = LoggerFactory.getLogger(TextInverseDecorator.class);
    /**
     * TextInverseDecorator constructor

     * @param textTransform implements TextTransform to decorate
     */
    public TextInverseDecorator(TextTransform textTransform) {
        super(textTransform);
    }

    /**
     * @param text - text obtained from client
     * @return formatted text inverted
     */
    @Override
    public String apply(String text) {
        var reversed = new StringBuilder(text).reverse().toString();
        logger.debug(String.format("text: %s, reversed: %s",text,reversed));
        logger.info("Successfully reversed!");
        return super.apply(reversed); //Creating new StringBuilder to use the method reverse on it
    }


}
