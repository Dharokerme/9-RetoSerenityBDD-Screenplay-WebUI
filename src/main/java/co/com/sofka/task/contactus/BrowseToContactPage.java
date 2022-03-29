package co.com.sofka.task.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.home.Home.CONTACT_BUTTON;

public class BrowseToContactPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CONTACT_BUTTON),
                Click.on(CONTACT_BUTTON));
    }

    public static BrowseToContactPage browseToTheContactPage() {
        return new BrowseToContactPage();
    }
}
