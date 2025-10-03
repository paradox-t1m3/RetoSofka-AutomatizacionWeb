package us.abstracta.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import us.abstracta.opencart.interactions.waits.WaitElementVisibleInteraction;
import us.abstracta.opencart.interactions.waits.WaitMomentInteraction;

import static us.abstracta.opencart.userinterfaces.YourStoreInterface.*;

public class AddItemsToShoopingCartTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitElementVisibleInteraction.of(LBL_TITLE_YOUR_STORE, 5),(Scroll.to(INFO_BNR)));
        for (int i = 1; i <= 2; i++) {
            actor.attemptsTo(Scroll.to(INFO_BNR));
            if (BTN_ADD_TO_CART.of(String.valueOf(i)).resolveFor(actor).isClickable()) {
                actor.attemptsTo(Scroll.to(BTN_ADD_TO_CART.of(String.valueOf(i))),Click.on(BTN_ADD_TO_CART.of(String.valueOf(i))), WaitMomentInteraction.pauseForSeconds(1));
            }
        }

        actor.attemptsTo(Click.on(BTN_CART),(WaitMomentInteraction.pauseForSeconds(1)));
        actor.attemptsTo(Click.on(BTN_CART_CHECKOUT),(WaitMomentInteraction.pauseForSeconds(2)));
    }

    public static AddItemsToShoopingCartTask fromPage() {
        return Tasks.instrumented(AddItemsToShoopingCartTask.class);
    }
}
