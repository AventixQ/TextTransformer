/**
 * 2023-12-13
 * L13-delta
 */

package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * This is class for creating abbreviations in text.
 */

public class TextAbbreviationDecorator extends TextDecorator {
    /**
     * Logger (SL4J library) for displaying messages on console.
     */
    final private static Logger logger = LoggerFactory.getLogger(TextAbbreviationDecorator.class);
    /**
     * TextAbbreviationDecorator constructor
     * @param textTransform implements TextTransform to decorate
     */
    public TextAbbreviationDecorator(TextTransform textTransform) { super(textTransform); }

    /**
     * HashMap with all possible abbreviations to change by apply() method.
     */

    private static final Map<String, String> ABBREVIATIONS_MAP = new HashMap<>();

    //zbiór reguł słów i ich skrótów
    static {
        ABBREVIATIONS_MAP.put("na przykład", "np.");
        ABBREVIATIONS_MAP.put("między innymi", "m.in.");
        ABBREVIATIONS_MAP.put("i tym podobne", "itp.");
    }

    /**
     * @param text - text obtained from client
     * @return formatted text with abbreviations
     */

    @Override
    public String apply(String text) {
        String inputSentence = text;
        for (Map.Entry<String, String> entry : ABBREVIATIONS_MAP.entrySet()) {
            String wordToReplace = entry.getKey();
            String abbreviation = entry.getValue();

            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(wordToReplace) + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            text = matcher.replaceAll(abbreviation);
        }
        logger.debug(String.format("text: %s, abbreviated: %s", inputSentence, text));
        logger.info("Successfully abbreviated!");
        return super.apply(text);
    }
}
