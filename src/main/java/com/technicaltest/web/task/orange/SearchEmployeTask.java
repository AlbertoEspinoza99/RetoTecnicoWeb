package com.technicaltest.web.task.orange;

import com.technicaltest.web.interaction.Wait;
import com.technicaltest.web.utils.UtilApp;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.technicaltest.web.uInterface.orange.SearchEmployeeUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchEmployeTask implements Task {


    public static SearchEmployeTask Search() {
        return instrumented(SearchEmployeTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String nroId= UtilApp.getJsonValue("IDEmploye","$['idEmploye']");


      actor.attemptsTo(
              WaitUntil.the(inputEmpleyeID,isVisible()).forNoMoreThan(30).seconds(),
              Enter.theValue(nroId).into(inputEmpleyeID),
              Wait.ww(2),
              WaitUntil.the(btnSearch,isVisible()).forNoMoreThan(30).seconds(),
              Click.on(btnSearch),
              Wait.ww(1),
              WaitUntil.the(spinner,isNotVisible()).forNoMoreThan(30).seconds(),
              Wait.ww(1)

              );


    }



}
