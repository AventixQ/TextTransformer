/**
 * 2023-12-13
 * L13-delta
 */

package pl.put.poznan.transformer.logic.decorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransform;
import pl.put.poznan.transformer.logic.decorators.data.NumbersHashMap;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * This is class for changing numbers to sting in text.

 * It is extending TextDecorator class and
 * overrides apply() method to create sentence with
 * float numbers converted to Polish words.

 * It is taking care of full sentences with numbers 1 - 1000 to decimal places.
 * If conditions are not met, the unchanged sentence is printed.

 *
 * @author L13-delta group
 * @see TextTransform
 * @see TextDecorator
 */

public class TextNumbersToStringDecorator extends TextDecorator {
    private static Logger logger = LoggerFactory.getLogger(TextNumbersToStringDecorator.class);
    /**
     * TextNumbersToStringDecorator constructor

     * @param textTransform implements TextTransform to decorate
     */
    public TextNumbersToStringDecorator(TextTransform textTransform) { super(textTransform); }

    /**
     * Function to convert given number into merged text with spaces
     * @param number - number from given text converted into integer
     * @return formatted number to string Polish words with spaces
     */

    private static String convertNumberToWords(int number) {
        int len = Integer.toString(number).length();
        StringBuilder transformedText = new StringBuilder();
        if(number <= 20){
            String numberInWords = NumbersHashMap.NUMBERS_MAP.get(number);
            transformedText.append(numberInWords).append(" ");
        }
        else{
            while (len > 0) {
                len--;
                int power = (int) Math.pow(10, len);
                int toText = number / power;

                if (toText != 0) {
                    String numberInWords = NumbersHashMap.NUMBERS_MAP.get(toText * power);
                    transformedText.append(numberInWords).append(" ");
                    number = number % power;
                }
            }
        }
        return transformedText.toString().trim();
    }

    /**
     * Override method apply()
     * Function is taking string text and converting numbers to words
     * with function @convertNumberToWords if possible.
     * If not function will return string text.

     * @param text - text obtained from client
     * @return formatted string from given text with number if possible
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
                    int numberDecLen = parts[1].length();
                    if (numberInt <= 1000 && numberDec < 100 && numberDecLen < 3){
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
        String finalSentence = transformedText.toString().trim();
        logger.debug(String.format("text: %s, converted: %s", text, finalSentence));
        logger.info("Successfully converted!");
        return super.apply(transformedText.toString().trim());
    }
}