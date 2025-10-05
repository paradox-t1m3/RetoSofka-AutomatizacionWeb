package us.abstracta.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.abstracta.opencart.interactions.waits.WaitElementVisibleInteraction;

import static us.abstracta.opencart.userinterfaces.YourStoreInterface.*;

/**
 * Opens the shopping cart from the home page.
 */

public class OpenEmptyShoopingCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitElementVisibleInteraction.of(BTN_CART, 5));
        actor.attemptsTo(Click.on(BTN_CART));
    }

    public static OpenEmptyShoopingCart fromHomePage() {
        return Tasks.instrumented(OpenEmptyShoopingCart.class) ;
    }
}
