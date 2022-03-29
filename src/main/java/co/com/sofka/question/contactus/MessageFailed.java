package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.contactus.ContacUs.ERROR;

public class MessageFailed implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return ERROR.resolveFor(actor).containsText("Invalid email address.");
    }
    public static MessageFailed isFailed() {
        return new MessageFailed();
    }
}
