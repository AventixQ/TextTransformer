package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is class for creating abbreviations in text.
 */

public class TextAbbreviationDecorator extends TextDecorator {
    public TextAbbreviationDecorator(TextTransform textTransform) { super(textTransform); }

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

        for (Map.Entry<String, String> entry : ABBREVIATIONS_MAP.entrySet()) {
            String wordToReplace = entry.getKey();
            String abbreviation = entry.getValue();

            // Use regular expression with Pattern.CASE_INSENSITIVE flag
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(wordToReplace) + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            // Perform case-insensitive replacement
            text = matcher.replaceAll(abbreviation);
        }

        return super.apply(text);
    }
}
