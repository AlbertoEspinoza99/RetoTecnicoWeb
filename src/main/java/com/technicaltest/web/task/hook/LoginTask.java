package com.technicaltest.web.task.hook;

import com.technicaltest.web.interaction.Wait;
import com.technicaltest.web.uInterface.common.Constantes;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.technicaltest.web.uInterface.common.LoginUi.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

    private String user;
    private String pass;
    private final String application;

    public LoginTask(String application) {
        this.application = application;
    }

    public static LoginTask login(String application){
        return Instrumented.instanceOf(LoginTask.class).withProperties(application);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        user=actor.recall(Constantes.USERNAME);
        pass=actor.recall(Constantes.PASSWORD);

        switch (application)
        {
            case "orangeHrm":

                actor.attemptsTo(

                        WaitUntil.the(inputUsername,isVisible()).forNoMoreThan(50).seconds(),
                        Enter.theValue(user).into(inputUsername),
                        Wait.ww(1),
                        WaitUntil.the(inputPass,isVisible()).forNoMoreThan(50).seconds(),
                        Enter.theValue(pass).into(inputPass),
                        Wait.ww(2),
                        Click.on(btnLogin)


                );

                break;


            default:

                actor.attemptsTo(
                        Wait.ww(2)
                );


                break;

        }







    }





}
