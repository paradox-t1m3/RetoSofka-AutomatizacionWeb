package us.abstracta.opencart.interactions.waits;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Waits until a UI element becomes visible within a given timeout.
 */


public class WaitElementVisibleInteraction implements Interaction {
    private Target target;
    private int seconds;

    public WaitElementVisibleInteraction(Target target, int seconds) {
        this.target = target;
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(target, isVisible()).forNoMoreThan(seconds).seconds());
    }

    public static WaitElementVisibleInteraction of(Target target, int seconds) {
        return Tasks.instrumented(WaitElementVisibleInteraction.class, target, seconds);
    }

}
