package co.com.sofka.question.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.createaccountorsignin.CreateAccountOrSignIn.LOGOUT;

public class CreateAccountValidation implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        return (LOGOUT.resolveFor(actor).isVisible());
    }

    public static CreateAccountValidation isCreated() {
        return new CreateAccountValidation();
    }
}
