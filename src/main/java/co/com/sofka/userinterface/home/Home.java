package co.com.sofka.userinterface.home;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Home extends PageObject {
    public static final Target SIGN_IN_BUTTON = Target
            .the("Sign in button")
            .located(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));

    public static final Target CONTACT_BUTTON = Target
            //located by //*[@id="contact-link"]/a
            .the("Contact button")
            .located(By.xpath("//*[@id=\"contact-link\"]/a"));
}
