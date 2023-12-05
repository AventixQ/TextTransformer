package pl.put.poznan.transformer.logic;

public class Uppercase extends TextDecorator{

    public Uppercase(TextTransform textTransform) {
        super(textTransform);
    }

    @Override
    public String apply(String text)
    {
        String transformedText = super.apply(text);
        return transformedText.toUpperCase();
    }
}