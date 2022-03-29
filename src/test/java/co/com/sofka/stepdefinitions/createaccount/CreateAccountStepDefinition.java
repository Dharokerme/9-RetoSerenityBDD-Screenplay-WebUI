package co.com.sofka.stepdefinitions.createaccount;

import co.com.sofka.stepdefinitions.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.actions.Scroll;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hamcrest.Matchers;

import static co.com.sofka.question.createaccount.CreateAccountAlreadyRegistred.isAlreadyRegistred;
import static co.com.sofka.question.createaccount.CreateAccountValidation.isCreated;
import static co.com.sofka.task.createaccount.BrowseToRegisterPage.browseToTheRegisterPage;
import static co.com.sofka.task.createaccount.BrowseToRegisterPageAlready.browseToTheRegisterPageAlready;
import static co.com.sofka.task.createaccount.FillTheForm.fillTheForm;
import static co.com.sofka.task.landingPage.OpenLandingPage.openLandingPage;
import static co.com.sofka.userinterface.createaccountorsignin.CreateAccountOrSignIn.ERRORMESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class CreateAccountStepDefinition extends SetUp {

    private static final String USUARIO = "Usuario";
    private static final String EMAIL = randomEmail();
    private static final Logger LOGGER = Logger.getLogger(CreateAccountStepDefinition.class);

    @Given("el usuario se encuentra en la pagina de inicio")
    public void elUsuarioSeEncuentraEnLaPaginaDeInicio() {
        actorSetupTheBrowser(USUARIO);
        theActorInTheSpotlight().wasAbleTo(openLandingPage());

    }

    @When("ingreso sus datos de registro correctamente")
    public void ingresoSusDatosDeRegistroCorrectamente() {
        theActorInTheSpotlight().attemptsTo(
                browseToTheRegisterPage()
                        .usingTheEmail(EMAIL),
                fillTheForm()
                        .usingTheFirst_name("Juan")
                        .usingTheLast_name("Perez")
                        .usingThePassword("12345678")
                        .usingTheAddress("Calle 123")
                        .usingTheCity("Medellin")
                        .usingThePostal_code("12345")
                        .usingTheMobile_phone("123456789")
                        .usingTheAlias("Juan Perez"));
    }

    @Then("Entonces deberia ver el mensaje de bienvenida")
    public void entoncesDeberiaVerElMensajeDeBienvenida() {
        theActorInTheSpotlight().should(
                seeThat(isCreated(), Matchers.equalTo(true)));
    }

    @When("ingresa un correo ya existente")
    public void ingresaUnCorreoYaExistente() {
        theActorInTheSpotlight().attemptsTo(
                browseToTheRegisterPageAlready()
                        .usingTheEmail(EMAIL));
    }

    @Then("deberia ver un mensaje de error")
    public void deberiaVerUnMensajeDeError() {
        theActorInTheSpotlight().should(
                seeThat(isAlreadyRegistred(), Matchers.equalTo(true)));
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
