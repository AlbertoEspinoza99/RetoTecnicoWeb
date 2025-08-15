package com.technicaltest.web.uInterface.orange;

import net.serenitybdd.screenplay.targets.Target;

public class SearchEmployeeUI {


    public static final Target inputEmpleyeID=Target.the("income ID")
            .locatedBy("(//text()[contains(.,'Employee Information')]/parent::h5/ancestor::div[3]/div[2]/form/div[1]//input)[2]");


    public static final Target btnSearch=Target.the("I select button Search")
            .locatedBy("//button[@type='submit' and contains(normalize-space(.),'Search')]");


    public static final Target spinner=Target.the("spinner")
            .locatedBy("//div[@class='oxd-loading-spinner']");






}
