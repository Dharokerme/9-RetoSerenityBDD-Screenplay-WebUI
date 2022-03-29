package co.com.sofka.stepdefinitions.contactus;

import co.com.sofka.stepdefinitions.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static co.com.sofka.question.contactus.MessageFailed.isFailed;
import static co.com.sofka.question.contactus.MessageSendedOk.isSendedOk;
import static co.com.sofka.task.contactus.BrowseToContactPage.browseToTheContactPage;
import static co.com.sofka.task.contactus.FillTheContactFormEmpty.fillTheContactFormEmpty;
import static co.com.sofka.task.landingPage.OpenLandingPage.openLandingPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static co.com.sofka.task.contactus.FillTheContactForm.fillTheContactForm;

public class ContactStepDefinition extends SetUp {

    private static final String EMAIL = randomEmail();
    private static final String USUARIO = "usuario";

    @Given("que un usuario quiere contactarse con el administrador")
    public void queUnUsuarioQuiereContactarseConElAdministrador() {
        actorSetupTheBrowser(USUARIO);
        theActorInTheSpotlight().wasAbleTo(openLandingPage());

    }

    @When("envia un mensaje al administrador")
    public void enviaUnMensajeAlAdministrador() {

        theActorInTheSpotlight().attemptsTo(
                browseToTheContactPage(),
                fillTheContactForm()
                        .usingTheEmail(EMAIL)
                        .usingTheOrder("1234")
                        .usingTheMessage("Hello, i need an advice about...")
        );
    }

    @Then("se debe mostrar un mensaje de exito")
    public void seDebeMostrarUnMensajeDeExito() {
        theActorInTheSpotlight().should(
                seeThat(isSendedOk(), Matchers.equalTo(true)));
    }

    @When("envia un mensaje erroneo al administrador")
    public void enviaUnMensajeErroneoAlAdministrador() {
        theActorInTheSpotlight().attemptsTo(
                browseToTheContactPage(),
                fillTheContactFormEmpty()
        );
    }

    @Then("se debe mostrar un mensaje de error")
    public void seDebeMostrarUnMensajeDeError() {
        theActorInTheSpotlight().should(
                seeThat(isFailed(), Matchers.equalTo(true)));
    }

    //ramdom email generator function with @gmail.com
    public static String randomEmail() {
        String ABECEDARIO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder palabra = new StringBuilder();
        java.util.Random rnd = new java.util.Random();
        while (palabra.length() < 10) {
            int index = (int) (rnd.nextFloat() * ABECEDARIO.length());
            palabra.append(ABECEDARIO.charAt(index));

        }
        String palabraStr = palabra.toString();
        return palabraStr + "@gmail.com";
    }
}
