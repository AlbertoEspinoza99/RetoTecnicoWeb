package com.technicaltest.web.interaction;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.JavascriptExecutor;

public class ClearInput implements Interaction, IsHidden {

    private final Target inputTarget;

    public ClearInput(Target inputTarget) {
        this.inputTarget = inputTarget;
    }

    public static ClearInput of(Target inputTarget) {
        return Tasks.instrumented(ClearInput.class, inputTarget);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElementFacade element = inputTarget.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) ((WebDriverFacade) Serenity.getWebdriverManager().getCurrentDriver()).getProxiedDriver();

        // Vaciar el input
        js.executeScript("arguments[0].value = '';", element);

        // Disparar eventos para que la app reconozca el cambio
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", element);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", element);
    }



}
