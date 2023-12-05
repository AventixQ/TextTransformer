package pl.put.poznan.transformer.logic;

/**
 * This text Decorator
 */
public abstract class TextDecorator implements TextTransform {
    protected TextTransform transform;

    public TextDecorator(TextTransform textTransform) {

        transform = textTransform;
    }
    protected abstract String operation(String text);
    @Override
    final public String apply(String text) {
        return textTransform.apply(operation(text));
    }
}