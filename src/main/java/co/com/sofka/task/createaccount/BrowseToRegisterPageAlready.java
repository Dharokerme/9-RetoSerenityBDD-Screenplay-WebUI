package co.com.sofka.task.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.createaccountorsignin.CreateAccountOrSignIn.*;
import static co.com.sofka.userinterface.home.Home.SIGN_IN_BUTTON;

public class BrowseToRegisterPageAlready implements Task {

    private String email;

    public BrowseToRegisterPageAlready usingTheEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGN_IN_BUTTON),
                Click.on(SIGN_IN_BUTTON),

                Scroll.to(REGISTER_TEXT_EMAIL),
                Enter.theValue(email).into(REGISTER_TEXT_EMAIL),
                Scroll.to(CREATE_AN_ACCOUNT_BUTTON),
                Click.on(CREATE_AN_ACCOUNT_BUTTON),

                Scroll.to(ERRORMESSAGE));
    }

    public static BrowseToRegisterPageAlready browseToTheRegisterPageAlready() {
        return new BrowseToRegisterPageAlready();
    }
}
