package co.com.sofka.stepdefinitions.signin;

import co.com.sofka.stepdefinitions.createaccount.CreateAccountStepDefinition;
import co.com.sofka.stepdefinitions.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import static co.com.sofka.question.createaccount.CreateAccountAlreadyRegistred.isAlreadyRegistred;
import static co.com.sofka.question.createaccount.CreateAccountValidation.isCreated;
import static co.com.sofka.question.signin.errorAuthentification.isShown;
import static co.com.sofka.task.createaccount.BrowseToRegisterPage.browseToTheRegisterPage;
import static co.com.sofka.task.createaccount.FillTheForm.fillTheForm;
import static co.com.sofka.task.landingPage.OpenLandingPage.openLandingPage;
import static co.com.sofka.task.signin.BrowseOnlyToRegisterPage.browseToTheRegisterPage3;
import static co.com.sofka.task.signin.BrowseToRegisterPageWithRegistration.browseToTheRegisterPage2;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SignInStepDefinition extends SetUp {

    private static final String USUARIO = "user";
    private static final String EMAIL = randomEmail();
    private static final Logger LOGGER = Logger.getLogger(SignInStepDefinition.class);


    @Given("que el usuario se encuentra en la pagina de inicio")
    public void queElUsuarioSeEncuentraEnLaPaginaDeInicio() {
        actorSetupTheBrowser(USUARIO);
        theActorInTheSpotlight().wasAbleTo(openLandingPage());
    }

    @When("ingresa al sistema")
    public void ingresaAlSistema() {
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
                        .usingTheAlias("Juan Perez"),
                browseToTheRegisterPage2()
                        .usingTheEmail(EMAIL)
                        .usingThePassword("12345678"));
    }

    @Then("deberia ver el mensaje de bienvenida")
    public void deberiaVerElMensajeDeBienvenida() {
        theActorInTheSpotlight().should(
                seeThat(isCreated(), Matchers.equalTo(true)));

    }

    @When("ingreso al sistema incorrectamente")
    public void ingresoAlSistemaIncorrectamente() {
        theActorInTheSpotlight().attemptsTo(
                browseToTheRegisterPage3()
                        .usingTheEmail(EMAIL)
                        .usingThePassword("1234"));
    }

    @Then("deberia ver el mensaje de error")
    public void deberiaVerElMensajeDeError() {
        theActorInTheSpotlight().should(
                seeThat(isShown(), Matchers.equalTo(true)));
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
