package pruebas.definition.common;

import com.technicaltest.web.interaction.Wait;
import com.technicaltest.web.task.hook.LoginTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.technicaltest.web.uInterface.common.Options.btnOption;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static pruebas.definition.hook.Hooks.actor;

public class CommonDefinitions {


    @Given("^access to the application --> (.*)$")
    public void accessapplication(String application){

        actor.wasAbleTo(Open.browserOn().thePageNamed("pages."+application));
        actor.attemptsTo(
                LoginTask.login(application)
        );

    }

    @When("^access to the option --> (.*)$")
    public void option(String options){

        actor.attemptsTo(

                WaitUntil.the(btnOption.of(options),isVisible()).forNoMoreThan(30).seconds(),
                Wait.ww(2),
                JavaScriptClick.on(btnOption.of(options))

        );


    }








}
