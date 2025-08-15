package com.technicaltest.web.uInterface.orange;

import net.serenitybdd.screenplay.targets.Target;

public class ValidationRegisterEmployeeUI {

    public static final Target divIdEmployee=Target.the("div divIdEmployee")
            .locatedBy("//text()[contains(.,'(1) Record Found')]/parent::span/ancestor::div[3]/div[3]/div/div[2]/div/div/div[2]/div");

    public static final Target divLastNameEmployee=Target.the("div LastNameEmployee")
            .locatedBy("//text()[contains(.,'(1) Record Found')]/parent::span/ancestor::div[3]/div[3]/div/div[2]/div/div/div[4]/div");




}
