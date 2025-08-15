package com.technicaltest.web.uInterface.common;

import net.serenitybdd.screenplay.targets.Target;

public class Options {

    public static final Target btnOption=Target.the("btnOption")
            .locatedBy("//text()[contains(.,'{0}')]/parent::span/parent::a");


}
