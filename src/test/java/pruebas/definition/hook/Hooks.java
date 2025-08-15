package pruebas.definition.hook;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;


import static com.technicaltest.web.uInterface.common.Constantes.*;
import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {


    public static final Actor actor = Actor.named("Usuario");
    private long startTime;

    @Before
    public void beforeScenario() {
        startTime = System.currentTimeMillis();
    }

    @Before
    public void setTheStage(Scenario scenario) {
        System.out.println("Inicializando el escenario...");

        String ambiente;
        String username;
        String password;

        System.out.println("Tags del escenario: " + scenario.getSourceTagNames());

        if (scenario.getSourceTagNames().contains("@Orange")) {
            ambiente = "Orange";
            username = System.getenv("username_Orange");
            password = System.getenv("password_Orange");

        } else   {
            ambiente = "otros";
            username = System.getenv("username_otros");
            password = System.getenv("password_otros");
        }


        if (username == null || password == null) {
            try (InputStream input = Hooks.class.getClassLoader().getResourceAsStream("secrets.properties")) {
                if (input != null) {

                    Properties props = new Properties();
                    props.load(input);

                    if (ambiente.equals("Orange")) {
                        username = props.getProperty("username_Orange");
                        password = props.getProperty("password_Orange");
                    } else {
                        username = props.getProperty("username_otros");
                        password = props.getProperty("password_otros");
                    }
                } else {
                    Logger.getAnonymousLogger().info("No se encontró el archivo secrets.properties");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        OnStage.setTheStage(new OnlineCast());

        WebDriver driver = ThucydidesWebDriverSupport.getDriver();

        actor.can(BrowseTheWeb.with(driver));

        getDriver().manage().window().maximize();

        actor.remember(USERNAME, username);
        actor.remember(PASSWORD, password);

    }

    @After
    public void tearDown() {
        // Limpiar datos después de que se hayan ejecutado las pruebas
        OnStage.drawTheCurtain();
    }





}
