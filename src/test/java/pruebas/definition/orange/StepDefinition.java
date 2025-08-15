package pruebas.definition.orange;

import com.technicaltest.web.model.common.Usuario;
import com.technicaltest.web.questions.orange.RegisterEmployeValidation;
import com.technicaltest.web.task.orange.RegisterEmpleyeTask;
import com.technicaltest.web.task.orange.SearchEmployeTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;

import static org.hamcrest.CoreMatchers.equalTo;
import static pruebas.definition.hook.Hooks.actor;

public class StepDefinition {

    @And("^We registered a new employee$")
    public void register(DataTable table){

       actor.attemptsTo(
               RegisterEmpleyeTask.register(Usuario.lista(table).get(0))
       );

    }


    @And("we are looking for the registered employee")
    public void weAreLookingForTheRegisteredEmployee() {

        actor.attemptsTo(
                SearchEmployeTask.Search()
        );


    }


    @Then("we validate the successful registration")
    public void weValidateTheSuccessfulRegistration() {

        actor.should(
                GivenWhenThen.seeThat("validamos la exitencia del empleado creado",
                        RegisterEmployeValidation.validationd(),equalTo(true))
        );

    }



}
