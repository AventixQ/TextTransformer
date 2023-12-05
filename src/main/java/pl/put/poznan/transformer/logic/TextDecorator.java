package pl.put.poznan.transformer.logic;

/**
 * TextDecorator
 *
 */
public abstract class TextDecorator implements TextTransform {
    protected final TextTransform textTransform;

    public TextDecorator(TextTransform textTransform) {
        this.textTransform = textTransform;
    }

    // metoda do przekazania tekstu do dekorowanego obiektu
    @Override
    public String apply(String text) {
        return textTransform.apply(text);
    }
}