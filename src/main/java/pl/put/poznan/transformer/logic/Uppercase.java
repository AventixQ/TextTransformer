package pl.put.poznan.transformer.logic;

public class Uppercase extends TextDecorator{

    public Uppercase(TextTransform textTransform) {
        super(textTransform);
    }

    public String apply(String text)
    {
        String transformedText = textTransform.apply(text);
        return transformedText.toUpperCase();
    }
}