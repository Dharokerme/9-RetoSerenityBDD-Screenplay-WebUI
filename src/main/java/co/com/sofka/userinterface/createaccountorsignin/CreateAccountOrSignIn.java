package co.com.sofka.userinterface.createaccountorsignin;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateAccountOrSignIn extends PageObject {

    public static final Target REGISTER_TEXT_EMAIL = Target
            .the("Register text email")
            .located(By.id("email_create"));

    public static final Target CREATE_AN_ACCOUNT_BUTTON = Target
            .the("Create an account button")
            .located(By.xpath("//*[@id=\"SubmitCreate\"]"));

    //FORMULARIO DE REGISTRO
    public static final Target FIRST_NAME = Target
            .the("First name space")
            .located(By.id("customer_firstname"));

    public static final Target LAST_NAME = Target
            .the("Last name space")
            .located(By.id("customer_lastname"));

    public static final Target PASSWORD = Target
            .the("Password space")
            .located(By.id("passwd"));

    public static final Target ADDRESS = Target
            .the("Address space")
            .located(By.id("address1"));

    public static final Target CITY = Target
            .the("City space")
            .located(By.id("city"));

    //dropdown list for state
    public static final Target STATE = Target
            .the("State space")
            .located(By.xpath("//*[@id=\"id_state\"]"));

    public static final Target POSTAL_CODE = Target
            .the("Postal Code space")
            .located(By.id("postcode"));

    //dropdown list for country
    public static final Target COUNTRY = Target
            .the("Country selection")
            .located(By.id("id_country"));

    public static final Target PHONE = Target
            .the("Phone")
            .located(By.id("phone_mobile"));

    public static final Target ALIAS = Target
            .the("Alias")
            .located(By.id("alias"));

    public static final Target REGISTERBUTTON = Target
            .the("Register")
            .located(By.cssSelector("#submitAccount > span"));

    public static final Target LOGOUT = Target
            .the("InfoAccount")
            .located(By.className("info-account"));

    public static final Target ERRORMESSAGE = Target
            .the("Error Message")
            .located(By.id("create_account_error"));



}
