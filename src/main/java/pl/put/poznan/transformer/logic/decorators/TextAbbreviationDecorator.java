package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

/**
 * This is class for creating abbreviations in text.
 */

public class TextAbbreviationDecorator extends TextDecorator {
    public TextAbbreviationDecorator(TextTransform textTransform) { super(textTransform); }

    /**
     * @param text - text obtained from client
     * @return formatted text with abbreviations
     */

    @Override
    public String apply(String text) {
        //TODO zrobic skróty

        return super.apply(text);
    }
}
