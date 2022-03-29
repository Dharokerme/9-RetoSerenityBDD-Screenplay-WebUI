package co.com.sofka.question.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.signin.SignIn.SIGN_IN_ERROR;

public class errorAuthentification implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        return (SIGN_IN_ERROR.resolveFor(actor).isVisible());
    }

    public static errorAuthentification isShown() {
        return new errorAuthentification();
    }
}
