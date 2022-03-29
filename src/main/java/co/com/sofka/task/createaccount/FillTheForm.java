package co.com.sofka.task.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.sofka.userinterface.createaccountorsignin.CreateAccountOrSignIn.*;
import static co.com.sofka.userinterface.signin.SignIn.SIGN_OUT_BUTTON;


public class FillTheForm implements Task {

    private String first_name;
    private String last_name;
    private String password;
    private String address;
    private String city;
    private String postal_code;
    private String mobile_phone;
    private String alias;

    public FillTheForm usingTheFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public FillTheForm usingTheLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public FillTheForm usingThePassword(String password) {
        this.password = password;
        return this;
    }

    public FillTheForm usingTheAddress(String address) {
        this.address = address;
        return this;
    }

    public FillTheForm usingTheCity(String city) {
        this.city = city;
        return this;
    }

    public FillTheForm usingThePostal_code(String postal_code) {
        this.postal_code = postal_code;
        return this;
    }

    public FillTheForm usingTheMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
        return this;
    }

    public FillTheForm usingTheAlias(String alias) {
        this.alias = alias;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(FIRST_NAME),
                Enter.theValue(first_name).into(FIRST_NAME),

                Scroll.to(LAST_NAME),
                Enter.theValue(last_name).into(LAST_NAME),

                Scroll.to(PASSWORD),
                Enter.theValue(password).into(PASSWORD),

                Scroll.to(ADDRESS),
                Enter.theValue(address).into(ADDRESS),

                Scroll.to(CITY),
                Enter.theValue(city).into(CITY),

                Scroll.to(STATE),
                Click.on(STATE),
                SelectFromOptions.byVisibleText("California").from(STATE),

                Scroll.to(POSTAL_CODE),
                Enter.theValue(postal_code).into(POSTAL_CODE),

                Scroll.to(COUNTRY),
                Click.on(COUNTRY),
                SelectFromOptions.byVisibleText("United States").from(COUNTRY),

                Scroll.to(PHONE),
                Enter.theValue(mobile_phone).into(PHONE),

                Scroll.to(ALIAS),
                Enter.theValue(alias).into(ALIAS),

                Scroll.to(REGISTERBUTTON),
                Click.on(REGISTERBUTTON),

                Scroll.to(SIGN_OUT_BUTTON)
        );

    }

    public static FillTheForm fillTheForm() {
        return new FillTheForm();
    }
}
