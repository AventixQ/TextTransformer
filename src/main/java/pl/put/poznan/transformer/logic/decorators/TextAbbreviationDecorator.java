package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

import java.util.HashMap;
import java.util.Map;

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
        String lowerCaseText = text.toLowerCase();

        for (Map.Entry<String, String> entry : ABBREVIATIONS_MAP.entrySet()) {
            String wordToReplace = entry.getKey().toLowerCase();
            String abbreviation = entry.getValue();
            lowerCaseText = lowerCaseText.replaceAll("\\b" + wordToReplace + "\\b", abbreviation);
        }

        return super.apply(lowerCaseText);
    }
}
