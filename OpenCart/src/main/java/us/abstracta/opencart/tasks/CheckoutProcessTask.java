package us.abstracta.opencart.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import us.abstracta.opencart.interactions.waits.WaitElementVisibleInteraction;
import us.abstracta.opencart.interactions.waits.WaitMomentInteraction;

import java.util.List;
import java.util.Locale;

import static us.abstracta.opencart.userinterfaces.CheckoutInterface.*;

public class CheckoutProcessTask implements Task {
    private List<String> info;
    private final Faker faker = new Faker(Locale.of("es-CO"));

    public CheckoutProcessTask(List<String> info) {
        this.info = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitElementVisibleInteraction.of(LBL_TITLE_CHECKOUT, 5));
        List<WebElementFacade> listNeCustomer = LST_RDB_NEW_CUSTOMER.resolveAllFor(actor);
        int newCustomer = 1;
        for (int i = 0; i < listNeCustomer.size(); i++) {
            if (listNeCustomer.get(i).getText().equals(info.get(0))) {
                actor.attemptsTo(Click.on(RDB_NEW_CUSTOMER.of(String.valueOf(newCustomer))));
            } else newCustomer++;
        }

        actor.attemptsTo(Click.on(BTN_CONTINUE_NEW_CUSTOMER), WaitMomentInteraction.pauseForSeconds(2));
        actor.attemptsTo(WaitElementVisibleInteraction.of(TXT_FIRST_NAME, 2));
        actor.attemptsTo(Enter.theValue(faker.name().firstName()).into(TXT_FIRST_NAME));
        actor.attemptsTo(Enter.theValue(faker.name().lastName()).into(TXT_LAST_NAME));
        actor.attemptsTo(Enter.theValue(faker.internet().emailAddress()).into(TXT_EMAIL));
        actor.attemptsTo(Enter.theValue(faker.phoneNumber().cellPhone()).into(TXT_TELEPHONE));

        actor.attemptsTo(Enter.theValue(faker.address().fullAddress()).into(TXT_ADDRESS_1));
        actor.attemptsTo(Enter.theValue(faker.address().cityName()).into(TXT_CITY));
        actor.attemptsTo(Enter.theValue(faker.address().zipCode()).into(TXT_CODE_POSTAL));

        actor.attemptsTo(Click.on(DDL_COUNTRY), WaitMomentInteraction.pauseForSeconds(1));
        List<WebElementFacade> listCountry = LST_COUNTRY.resolveAllFor(actor);
        int countryPosition = faker.number().numberBetween(1, listCountry.size() + 1);
        actor.attemptsTo(Click.on(ITM_COUNTRY.of(String.valueOf(countryPosition))),WaitMomentInteraction.pauseForSeconds(3));

        actor.attemptsTo(Click.on(DDL_REGION_STATE), WaitMomentInteraction.pauseForSeconds(1));
        List<WebElementFacade> listRegionState = LST_REGION_STATE.resolveAllFor(actor);
        int regionStatePosition = faker.number().numberBetween(1, listRegionState.size() + 1);
        actor.attemptsTo(Click.on(ITM_REGION_STATE.of(String.valueOf(regionStatePosition))),WaitMomentInteraction.pauseForSeconds(3));

        actor.attemptsTo(Click.on(BTN_CONTINUE_YOUR_PERSONAL_DETAILS), WaitMomentInteraction.pauseForSeconds(1));

        actor.attemptsTo(WaitElementVisibleInteraction.of(TXA_COMMENTS_ABOUT_ORDER_DELIVERY_METHOD, 2));
        actor.attemptsTo(Enter.theValue(faker.lorem().sentence()).into(TXA_COMMENTS_ABOUT_ORDER_DELIVERY_METHOD));
        actor.attemptsTo(Click.on(BTN_DELIVERY_METHOD), WaitMomentInteraction.pauseForSeconds(2));

        actor.attemptsTo(WaitElementVisibleInteraction.of(BTN_PAYMENT_METHOD, 2));
        actor.attemptsTo(Click.on(CHK_ACCEPT_TERM_AND_CONDITIONS));
        actor.attemptsTo(Click.on(BTN_PAYMENT_METHOD), WaitMomentInteraction.pauseForSeconds(2));

        actor.attemptsTo(WaitElementVisibleInteraction.of(BTN_CONFIRM_ORDER, 2));
        actor.attemptsTo(Scroll.to(BTN_CONFIRM_ORDER),Click.on(BTN_CONFIRM_ORDER));
    }

    public static CheckoutProcessTask execute(List<String> info) {
        return Tasks.instrumented(CheckoutProcessTask.class,info);
    }
}
