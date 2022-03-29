package co.com.sofka.question.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.createaccountorsignin.CreateAccountOrSignIn.ERRORMESSAGE;

public class CreateAccountAlreadyRegistred implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return ERRORMESSAGE.resolveFor(actor).isVisible();
    }
    public static CreateAccountAlreadyRegistred isAlreadyRegistred() {
        return new CreateAccountAlreadyRegistred();
    }
}
