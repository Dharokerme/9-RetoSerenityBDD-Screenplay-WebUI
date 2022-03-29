package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.contactus.ContacUs.SUCCESS;

public class MessageSendedOk implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return SUCCESS.resolveFor(actor).containsOnlyText("Your message has been successfully sent to our team.");
    }
    public static MessageSendedOk isSendedOk() {
        return new MessageSendedOk();
    }
}
