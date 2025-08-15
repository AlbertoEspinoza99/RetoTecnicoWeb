package com.technicaltest.web.uInterface.common;

import net.serenitybdd.screenplay.targets.Target;

public class LoginUi {



    public static final Target inputUsername=Target.the("inputUsername")
            .locatedBy("//input[@name='username']");

    public static final Target inputPass=Target.the("inputPass")
            .locatedBy("//input[@name='password']");

    public static final Target btnLogin=Target.the("btnLogin")
            .locatedBy("(//text()[contains(.,'Login')])[2]/parent::button");











}
