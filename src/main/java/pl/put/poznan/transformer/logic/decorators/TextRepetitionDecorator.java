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
 * This is class for removing repetitions from text.
 */

public class TextRepetitionDecorator extends TextDecorator {
    /**
     * Logger (SL4J library) for displaying messages on console.
     */
    final private static Logger logger = LoggerFactory.getLogger(TextRepetitionDecorator.class);
    /**
     * TextRepetitionDecorator constructor
     * @param textTransform implements TextTransform to decorate
     */
    public TextRepetitionDecorator(TextTransform textTransform) { super(textTransform); }

    /**
     * @param text - text obtained from client
     * @return formatted text without repetitions
     */

    @Override
    public String apply(String text) {
        String[] lines = text.split("\\n");

        StringBuilder resultBuilder = new StringBuilder();
        for (String line : lines) {
            String[] words = line.split("\\s+");

            StringBuilder lineResultBuilder = new StringBuilder();
            String previousWord = null;
            for (String currentWord : words) {
                if (!currentWord.trim().isEmpty()) {
                    if (!currentWord.equalsIgnoreCase(previousWord)) {
                        lineResultBuilder.append(currentWord).append(" ");
                    }
                    previousWord = currentWord;
                }
            }

            String lineResult = lineResultBuilder.toString().trim();

            resultBuilder.append(lineResult).append("\n");
        }
        String trimedResult = resultBuilder.toString().trim();

        logger.debug(String.format("text: %s, repetition removed: %s", text, trimedResult));
        logger.info("Repetitions successfully removed!");
        return super.apply(trimedResult);
    }
}