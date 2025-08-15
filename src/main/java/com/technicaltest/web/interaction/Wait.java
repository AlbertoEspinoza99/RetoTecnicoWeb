package com.technicaltest.web.interaction;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Wait implements Interaction {


    private final int second;

    public Wait(int second) {
        this.second = second;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {

            Thread.sleep(second* 1000);

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }

    public static Wait ww(int second){
        return Instrumented.instanceOf(Wait.class).withProperties(second);
    }



}
