package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

import java.util.HashMap;
import java.util.Map;

/**
 * This is class for expanding abbreviations in text.
 */

public class TextExpandAbbreviationDecorator extends TextDecorator {
    public TextExpandAbbreviationDecorator(TextTransform textTransform) { super(textTransform); }

    private static final Map<String, String> EXPAND_MAP = new HashMap<>();

    //zbiór reguł słów i ich skrótów
    static {
        EXPAND_MAP.put("np.", "na przykład");
        EXPAND_MAP.put("dr", "doktor");
        EXPAND_MAP.put("prof.", "profesor");
        EXPAND_MAP.put("itd.", "i tak dalej");
    }

    /**
     * Function is taking abbreviations from client and expanding it.\
     * function will prevent size of letters in input, while expended
     * @param text - text obtained from client
     * @return formatted text with expended abbreviations
     */

    @Override
    public String apply(String text) {
        String finalSentence = "";
        String[] words = text.split(" ");
        for(String word : words){
            try{
                String lowerCaseText = word.toLowerCase();
                String result = EXPAND_MAP.get(lowerCaseText);
                String result_tab[] = result.split(" ");
                result = "";
                if (word.endsWith(".")) {

                    for (int i = 0; i < word.length() - 1; i++) {
                        char currentChar = word.charAt(i);

                        if (Character.isUpperCase(currentChar)) {
                            result_tab[i] = result_tab[i].substring(0, 1).toUpperCase() + result_tab[i].substring(1);
                        }
                        result += result_tab[i] + " ";
                        //if(i < word.length() - 1) result += " ";
                    }
                }
                else {
                    char firstLetter = word.charAt(0);
                    if (Character.isUpperCase(firstLetter)) {
                        result_tab[0] = result_tab[0].substring(0, 1).toUpperCase() + result_tab[0].substring(1);
                        result += result_tab[0];

                    }
                    else {
                        result += result_tab[0];
                    }
                }
                finalSentence += result;
            }
            catch (Exception e){
                finalSentence += word + " ";
            }
        }

        return super.apply(finalSentence);
    }
}
