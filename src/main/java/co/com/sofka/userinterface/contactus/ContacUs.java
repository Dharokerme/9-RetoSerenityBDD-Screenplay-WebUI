package co.com.sofka.userinterface.contactus;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContacUs extends PageObject {

    public static final Target SUBJECT= Target
            .the("Subject Heading")
            .located(By.xpath("//*[@id=\"id_contact\"]"));

    public static final Target EMAIL= Target
            .the("Email Adress")
            .located(By.id("email"));

    public static final Target ORDER= Target
            .the("Order Reference")
            .located(By.id("id_order"));

    public static final Target MESSAGE= Target
            .the("Message")
            .located(By.id("message"));

    public static final Target SEND= Target
            .the("Send")
            .located(By.id("submitMessage"));

    public static final Target SUCCESS= Target
            .the("Success")
            .located(By.xpath("//*[@id=\"center_column\"]/p"));

    public static final Target ERROR= Target
            .the("Error")
            .located(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
}
