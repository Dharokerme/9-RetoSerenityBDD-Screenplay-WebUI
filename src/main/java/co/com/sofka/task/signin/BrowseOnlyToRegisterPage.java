package co.com.sofka.task.signin;

import co.com.sofka.userinterface.home.Home;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.signin.SignIn.*;
import static co.com.sofka.userinterface.signin.SignIn.SIGN_IN_BUTTON;

public class BrowseOnlyToRegisterPage implements Task {
    private String email;
    private String password;

    public BrowseOnlyToRegisterPage usingTheEmail(String email) {
        this.email = email;
        return this;
    }

    public BrowseOnlyToRegisterPage usingThePassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(Home.SIGN_IN_BUTTON),
                Click.on(Home.SIGN_IN_BUTTON),

                Scroll.to(LOGIN_FIELD),
                Enter.theValue(email).into(LOGIN_FIELD),

                Scroll.to(PASSWORD_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),

                Scroll.to(SIGN_IN_BUTTON),
                Click.on(SIGN_IN_BUTTON));

                Scroll.to(SIGN_IN_ERROR);
    }

    public static BrowseOnlyToRegisterPage browseToTheRegisterPage3() {
        return new BrowseOnlyToRegisterPage();
    }
}
