package us.abstracta.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import us.abstracta.opencart.interactions.AddProductInteraction;
import us.abstracta.opencart.interactions.waits.WaitElementVisibleInteraction;
import us.abstracta.opencart.interactions.waits.WaitMomentInteraction;

import static us.abstracta.opencart.userinterfaces.YourStoreInterface.*;

/**
 * Adds products to the cart and proceeds to checkout from the store page.
 */

public class AddItemsToShoopingCartTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitElementVisibleInteraction.of(LBL_TITLE_YOUR_STORE, 5),(Scroll.to(INFO_BNR)));
        actor.attemptsTo(AddProductInteraction.fromCatalog(INFO_BNR,BTN_ADD_TO_CART));
        actor.attemptsTo(Click.on(BTN_CART),(WaitMomentInteraction.pauseForSeconds(1)));
        actor.attemptsTo(Click.on(BTN_CART_CHECKOUT),(WaitMomentInteraction.pauseForSeconds(2)));
    }

    public static AddItemsToShoopingCartTask fromPage() {
        return Tasks.instrumented(AddItemsToShoopingCartTask.class);
    }
}
