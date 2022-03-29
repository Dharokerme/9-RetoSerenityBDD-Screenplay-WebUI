package co.com.sofka.task.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.contactus.ContacUs.SEND;

public class FillTheContactFormEmpty implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SEND),
                Click.on(SEND)
        );
    }

    public static FillTheContactFormEmpty fillTheContactFormEmpty() {
        return new FillTheContactFormEmpty();
    }
}

