package pruebas.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        features = "src/test/resources/features/",
        glue = "pruebas.definition",
        tags = "@Orange",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runners {

}
