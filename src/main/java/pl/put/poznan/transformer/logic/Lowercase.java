package pl.put.poznan.transformer.logic;

public class Lowercase extends TextDecorator {

    public Lowercase(TextTransform textTransform) {
        super(textTransform);
    }

    @Override
    public String apply(String text) {
        String transformedText = super.apply(text);
        return transformedText.toLowerCase();
    }
}
