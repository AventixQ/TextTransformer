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
    private static Logger logger = LoggerFactory.getLogger(TextRepetitionDecorator.class);
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
        // Split the text into an array of lines
        String[] lines = text.split("\\n");

        // Process each line separately and store the results
        StringBuilder resultBuilder = new StringBuilder();
        for (String line : lines) {
            // Split the line into words
            String[] words = line.split("\\s+");

            // Iterate through the words and remove consecutive repetitions
            StringBuilder lineResultBuilder = new StringBuilder();
            String previousWord = null;
            for (String currentWord : words) {
                // Ignore leading or trailing spaces
                if (!currentWord.trim().isEmpty()) {
                    // Remove repetitions
                    if (!currentWord.equalsIgnoreCase(previousWord)) {
                        lineResultBuilder.append(currentWord).append(" ");
                    }
                    previousWord = currentWord;
                }
            }

            // Trim leading and trailing spaces for the line
            String lineResult = lineResultBuilder.toString().trim();

            // Append the processed line to the result
            resultBuilder.append(lineResult).append("\n");
        }

        // Trim the trailing newline and apply transformations from the underlying decorator
        String trimedResult = resultBuilder.toString().trim();

        logger.debug(String.format("text: %s, repetition removed: %s", text, trimedResult));
        logger.info("Repetitions successfully removed!");
        return super.apply(trimedResult);
    }
}