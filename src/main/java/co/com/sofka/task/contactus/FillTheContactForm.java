package co.com.sofka.task.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.sofka.userinterface.contactus.ContacUs.*;


public class FillTheContactForm implements Task {

    private String email;
    private String order;
    private String message;

    public FillTheContactForm usingTheEmail(String email) {
        this.email = email;
        return this;
    }

    public FillTheContactForm usingTheOrder(String order) {
        this.order = order;
        return this;
    }

    public FillTheContactForm usingTheMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Scroll.to(SUBJECT),
                Click.on(SUBJECT),
                SelectFromOptions.byVisibleText("Webmaster").from(SUBJECT),

                Scroll.to(EMAIL),
                Enter.theValue(email).into(EMAIL),

                Scroll.to(ORDER),
                Enter.theValue(order).into(ORDER),

                Scroll.to(MESSAGE),
                Enter.theValue(message).into(MESSAGE),

                Scroll.to(SEND),
                Click.on(SEND),

                Scroll.to(SUCCESS)
        );
    }

    public static FillTheContactForm fillTheContactForm() {
        return new FillTheContactForm();
    }
}
