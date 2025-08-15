package com.technicaltest.web.questions.orange;

import com.technicaltest.web.utils.UtilApp;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.technicaltest.web.uInterface.orange.ValidationRegisterEmployeeUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterEmployeValidation implements Question<Boolean> {


    public static RegisterEmployeValidation validationd(){
        return new RegisterEmployeValidation();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String nroId= UtilApp.getJsonValue("IDEmploye","$['idEmploye']");
        String LastName= UtilApp.getJsonValue("IDEmploye","$['LastNameEmploye']");

        String ValorDomID=divIdEmployee.resolveFor(actor).getText();
        String ValorDomLastName=divLastNameEmployee.resolveFor(actor).getText();

        if (ValorDomID.equals(nroId) && ValorDomLastName.equals(LastName)){
            return true;
        }else {
            return false;
        }

    }



}
