package us.abstracta.opencart.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import us.abstracta.opencart.interactions.waits.WaitMomentInteraction;

import static us.abstracta.opencart.userinterfaces.YourStoreInterface.BTN_ADD_TO_CART;

/**
 * Adds products to the cart by scrolling and clicking if clickable.
 */

public class AddProductInteraction implements Interaction {
    private Target scrollTarget;
    private Target addToCart;

    public AddProductInteraction(Target scrollTarget, Target addToCart) {
        this.scrollTarget = scrollTarget;
        this.addToCart = addToCart;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 1; i <= 2; i++) {
            actor.attemptsTo(Scroll.to(scrollTarget));
            if (BTN_ADD_TO_CART.of(String.valueOf(i)).resolveFor(actor).isClickable()) {
                actor.attemptsTo(Scroll.to(addToCart.of(String.valueOf(i))), Click.on(addToCart.of(String.valueOf(i))), WaitMomentInteraction.pauseForSeconds(1));
            }
        }
    }

    public static AddProductInteraction fromCatalog(Target scrollTarget, Target addToCart) {
        return Tasks.instrumented(AddProductInteraction.class, scrollTarget, addToCart);
    }
}
