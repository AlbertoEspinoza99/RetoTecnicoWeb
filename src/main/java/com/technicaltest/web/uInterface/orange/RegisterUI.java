package com.technicaltest.web.uInterface.orange;

import net.serenitybdd.screenplay.targets.Target;

public class RegisterUI {


    public static final Target btnAdd=Target.the("select the button add")
            .locatedBy("(//text()[contains(.,'Add')])[2]/parent::button");


    public static final Target inputFirstName=Target.the("income FirstName")
            .locatedBy("//input[@name='firstName']");


    public static final Target inputMiddleName=Target.the("income MiddleName")
            .locatedBy("//input[@name='middleName']");


    public static final Target inputLastName=Target.the("income LastName")
            .locatedBy("//input[@name='lastName']");

   // aleatorio
    public static final Target inputEmployeID=Target.the("income ID")
            .locatedBy("(//label[contains(text(),'Employee Full Name')]/ancestor::div[6]/div[1]//input)[4]");


    public static final Target btnDetails=Target.the("I select button Details")
            .locatedBy("//label[contains(text(),'Employee Full Name')]/ancestor::div[6]/div[2]//span");


    // aleatorio
    public static final Target inputUsername=Target.the("income Username")
            .locatedBy("(//label[contains(text(),'Employee Full Name')]/ancestor::div[6]/div[3]//input)[1]");


    public static final Target inputPassword=Target.the("income Passwor")
            .locatedBy("(//label[contains(text(),'Employee Full Name')]/ancestor::div[6]/div[4]//input)[1]");


    public static final Target inputConfirmPassword=Target.the("income Confirm Password")
            .locatedBy("(//label[contains(text(),'Employee Full Name')]/ancestor::div[6]/div[4]//input)[2]");



    public static final Target btnSave=Target.the("I select button Save")
            .locatedBy("//text()[contains(.,'Save')]/parent::button");


    public static final Target spinner=Target.the("spinner")
            .locatedBy("//div[@class='oxd-loading-spinner']");


    public static final Target btnPim=Target.the("I select Pim")
            .locatedBy("//text()[contains(.,'PIM')]/parent::span/parent::a");












}
