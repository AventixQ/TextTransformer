package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.decorators.*;
import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;


@RestController
@RequestMapping("/api")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    //To na razie nie jest używane
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {


        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer();
        return transformer.apply(text);
    }

    //Poprawiony testowy post, żeby działał pod adresem: http://localhost:8080/api/test
    @RequestMapping(method = RequestMethod.POST, path ="/test" ,produces = "application/json")
    public String post(@RequestBody String transforms) {

        //przykładowe korzystanie z dekoratora (dla testowania swoich transformacji)
        TextDecorator transformer = new TextAbbreviationDecorator(new TextTransformer());
        return transformer.apply(transforms);
    }

    //Dla skrótów
    @RequestMapping(method = RequestMethod.POST, path ="/abbreviation" ,produces = "application/json")
    public String abbreviation(@RequestBody String transforms) {


        TextDecorator transformer = new TextAbbreviationDecorator(new TextTransformer());
        return transformer.apply(transforms);
    }

    //Dla usuwania powtórzeń
    @RequestMapping(method = RequestMethod.POST, path ="/repetition" ,produces = "application/json")
    public String repetition(@RequestBody String transforms) {


        TextDecorator transformer = new TextRepetitionDecorator(new TextTransformer());
        return transformer.apply(transforms);
    }
    
    //Dla zmiany liczb na słowa
    @RequestMapping(method = RequestMethod.POST, path ="/numberstostring" ,produces = "application/json")
    public String numberstostring(@RequestBody String transforms) {


        TextDecorator transformer = new TextNumbersToStringDecorator(new TextTransformer());
        return transformer.apply(transforms);
    }

    //Dla zamiany skrótów na słowa
    @RequestMapping(method = RequestMethod.POST, path ="/expandabbreviation" ,produces = "application/json")
    public String expandabbreviation(@RequestBody String transforms) {


        TextDecorator transformer = new TextExpandAbbreviationDecorator(new TextTransformer());
        return transformer.apply(transforms);
    }

    //Dla odwracania
    @RequestMapping(method = RequestMethod.POST, path ="/inverse" ,produces = "application/json")
    public String inverse(@RequestBody String transforms) {


        TextDecorator transformer = new TextInverseDecorator(new TextTransformer());
        return transformer.apply(transforms);
    }
    //Dla zmiany na duze litery
    @RequestMapping(method = RequestMethod.POST, path = "/uppercase", produces = "application/json")
    public String uppercase(@RequestBody String transforms) {
        TextDecorator transformer = new TextUpperCaseDecorator(new TextTransformer());
        return transformer.apply(transforms);
    }

    //Dla zamiany na małe litery
    @RequestMapping(method = RequestMethod.POST, path = "/lowercase", produces = "application/json")
    public String lowercase(@RequestBody String transforms) {
        TextDecorator transformer = new TextLowerCaseDecorator(new TextTransformer());
        return transformer.apply(transforms);
    }

    //Dla kapitalizacji
    @RequestMapping(method = RequestMethod.POST, path = "/capitalize", produces = "application/json")
    public String capitalize(@RequestBody String transforms) {
        TextDecorator transformer = new TextCapitalizeDecorator(new TextTransformer());
        return transformer.apply(transforms);
    }
}


