package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

/**
 * This is class for inverting the text.
 */
public class TextInverseDecorator extends TextDecorator {
    public TextInverseDecorator(TextTransform textTransform) {
        super(textTransform);
    }

    /**
     * @param text - text obtained from client
     * @return formatted text inverted
     */
    @Override
    public String apply(String text) {
        return super.apply((new StringBuilder(text)).reverse().toString()); //Creating new StringBuilder to use the method reverse on it :D
    }
}
