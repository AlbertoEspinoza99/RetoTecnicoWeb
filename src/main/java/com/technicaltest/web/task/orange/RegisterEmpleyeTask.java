package com.technicaltest.web.task.orange;

import com.technicaltest.web.interaction.ClearInput;
import com.technicaltest.web.interaction.Wait;
import com.technicaltest.web.model.common.Usuario;
import com.technicaltest.web.utils.UtilApp;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.json.JSONObject;

import static com.technicaltest.web.uInterface.orange.RegisterUI.*;
import static com.technicaltest.web.utils.UtilApp.aleatorio;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegisterEmpleyeTask implements Task {

    private final Usuario usu;

    public RegisterEmpleyeTask(Usuario usu) {
        this.usu = usu;
    }

    public static RegisterEmpleyeTask register(Usuario usu){
        return Instrumented.instanceOf(RegisterEmpleyeTask.class).withProperties(usu);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String ID="alb"+aleatorio();
        JSONObject json=new JSONObject();
        json.put("idEmploye",ID);
        json.put("LastNameEmploye",usu.getLastName());

        UtilApp.escribirJson(json,"IDEmploye");

        actor.attemptsTo(
                WaitUntil.the(btnAdd,isVisible()).forNoMoreThan(30).seconds(),
                Click.on(btnAdd),
                WaitUntil.the(inputFirstName,isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(usu.getFirtName()).into(inputFirstName),
                WaitUntil.the(inputMiddleName,isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(usu.getMiddleName()).into(inputMiddleName),
                WaitUntil.the(inputLastName,isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(usu.getLastName()).into(inputLastName),
                ClearInput.of(inputEmployeID),
                Wait.ww(2),
                Enter.theValue(ID).into(inputEmployeID),
                WaitUntil.the(btnDetails,isVisible()).forNoMoreThan(30).seconds(),
                JavaScriptClick.on(btnDetails),
                WaitUntil.the(inputUsername,isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(usu.getFirtName()+aleatorio()).into(inputUsername),
                WaitUntil.the(inputPassword,isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(usu.getPassword()).into(inputPassword),
                WaitUntil.the(inputConfirmPassword,isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(usu.getPassword()).into(inputConfirmPassword),
                WaitUntil.the(btnSave,isVisible()).forNoMoreThan(30).seconds(),
                Click.on(btnSave),
                WaitUntil.the(spinner,isNotVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(spinner,isNotVisible()).forNoMoreThan(30).seconds(),
                Wait.ww(2),
                Click.on(btnPim)

        );



    }




}
