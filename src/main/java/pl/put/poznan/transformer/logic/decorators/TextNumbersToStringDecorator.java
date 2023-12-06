package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;

import java.util.HashMap;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is class for changing numbers to sting in text.
 */

public class TextNumbersToStringDecorator extends TextDecorator {
    public TextNumbersToStringDecorator(TextTransform textTransform) { super(textTransform); }
    private static final Map<Integer, String> NUMBERS_MAP = new HashMap<>();
    private static final String CSV_FILE_PATH = "/data/numbers.csv";

    static {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("; ");
                int number = Integer.parseInt(values[0]);
                String word = values[1];
                NUMBERS_MAP.put(number, word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param text - text obtained from client
     * @return formatted string from given text with number
     */

    @Override
    public String apply(String text) {
        String[] words = text.split(" ");
        StringBuilder transformedText = new StringBuilder();

        for (String word : words) {
            try {
                int len = words.length;
                int number = Integer.parseInt(word);
                if (number < 1000){
                    while (len > 0){
                        len--;
                        int toText = number / 10 ^ len;
                        if(toText != 0) {
                            String numberInWords = NUMBERS_MAP.get(toText * (10 ^ len));
                            transformedText.append(numberInWords).append(" ");
                            number = number % 10 ^ len;
                        }
                    }
                }
                else{
                    transformedText.append(word).append(" ");
                }
            } catch (NumberFormatException e) {
                transformedText.append(word).append(" ");
            }
        }
        //System.out.println(transformedText.toString().trim());
        return super.apply(transformedText.toString().trim());
    }
}