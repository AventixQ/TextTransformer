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
     * Function to convert given @number into merged text with spaces
     * @param number - number from given text converted into integer
     * @return formatted number to string polish words with spaces
     */

    private static String convertNumberToWords(int number) {
        int len = Integer.toString(number).length();
        StringBuilder transformedText = new StringBuilder();
        while (len > 0) {
            len--;
            int power = (int) Math.pow(10, len);
            int toText = number / power;

            if (toText != 0) {
                String numberInWords = NUMBERS_MAP.get(toText * power);
                transformedText.append(numberInWords).append(" ");
                number = number % power;
            }
        }
        return transformedText.toString().trim();
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
                if(word.contains(",")){
                    String[] parts = word.split(",");
                    int len = word.length();
                    int numberInt = Integer.parseInt(parts[0]);
                    int numberDec = Integer.parseInt(parts[1]);
                    if (numberInt <= 1000 && numberDec < 100){
                        transformedText.append(convertNumberToWords(numberInt) + " i ");
                        transformedText.append(convertNumberToWords(numberDec) + " setnych ");
                    }
                    else{
                        transformedText.append(word).append(" ");
                    }
                }
                else{
                    int number = Integer.parseInt(word);
                    if (number < 1000){
                        transformedText.append(convertNumberToWords(number) + " ");
                    }
                    else{
                        transformedText.append(word).append(" ");
                    }
                }
            } catch (NumberFormatException e) {
                transformedText.append(word).append(" ");
            }
        }
        return super.apply(transformedText.toString().trim());
    }
}