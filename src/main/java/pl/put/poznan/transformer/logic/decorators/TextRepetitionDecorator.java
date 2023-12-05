package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

/**
 * This is class for removing repetitions from text.
 */

public class TextRepetitionDecorator extends TextDecorator {
    public TextRepetitionDecorator(TextTransform textTransform) { super(textTransform); }

    /**
     * @param text - text obtained from client
     * @return formatted text without repetitions
     */

    @Override
    public String apply(String text) {
        //TODO zrobic usuwanie powtórzeń

        return super.apply(text);
    }
}