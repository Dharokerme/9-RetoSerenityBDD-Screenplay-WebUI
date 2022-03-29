package co.com.sofka.userinterface.signin;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignIn extends PageObject {

    public static final Target LOGIN_FIELD = Target
            .the("Text email")
            .located(By.id("email"));

    public static final Target PASSWORD_FIELD = Target
            .the("Text password")
            .located(By.id("passwd"));

    public static final Target SIGN_IN_BUTTON = Target
            .the("Sign in button")
            .located(By.id("SubmitLogin"));

    public static final Target SIGN_IN_ERROR = Target
            .the("Sign in error")
            .located(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));

    public static final Target SIGN_OUT_BUTTON = Target
            .the("Sign out button")
            .located(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
}

