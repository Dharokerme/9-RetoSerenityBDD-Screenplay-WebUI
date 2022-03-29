package co.com.sofka.task.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.signin.SignIn.*;

public class BrowseToRegisterPageWithRegistration implements Task {

    private String email;
    private String password;

    public BrowseToRegisterPageWithRegistration usingTheEmail(String email) {
        this.email = email;
        return this;
    }

    public BrowseToRegisterPageWithRegistration usingThePassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SIGN_OUT_BUTTON),

                Scroll.to(LOGIN_FIELD),
                Enter.theValue(email).into(LOGIN_FIELD),

                Scroll.to(PASSWORD_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),

                Scroll.to(SIGN_IN_BUTTON),
                Click.on(SIGN_IN_BUTTON));
    }

    public static BrowseToRegisterPageWithRegistration browseToTheRegisterPage2() {
        return new BrowseToRegisterPageWithRegistration();
    }
}
