package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer implements TextTransform{


    @Override
    public String apply(String text){

        return text;
    }
}
