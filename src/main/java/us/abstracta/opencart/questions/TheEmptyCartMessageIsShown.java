package us.abstracta.opencart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.conditions.Check;
import us.abstracta.opencart.interactions.waits.WaitElementVisibleInteraction;

import java.util.List;

import static us.abstracta.opencart.userinterfaces.YourStoreInterface.LBL_CART_EMPTY;
import static us.abstracta.opencart.utils.Constants.RESULT_VIEW_MESSAGE_CART_EMPTY;

/**
 * Verifies if the empty cart message matches the expected value from Excel.
 */

public class TheEmptyCartMessageIsShown implements Question<Boolean> {
    private List<String> rowExcel;

    public TheEmptyCartMessageIsShown(List<String> rowExcel) {
        this.rowExcel = rowExcel;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitElementVisibleInteraction.of(LBL_CART_EMPTY, 2));
        actor.attemptsTo(Check.whether(LBL_CART_EMPTY.resolveFor(actor).getText().equals(rowExcel.get(1)))
                .andIfSo(RememberThat.theValueOf(RESULT_VIEW_MESSAGE_CART_EMPTY).is(true))
                .otherwise(RememberThat.theValueOf(RESULT_VIEW_MESSAGE_CART_EMPTY).is(false)));

        return actor.recall(RESULT_VIEW_MESSAGE_CART_EMPTY);
    }

    public static TheEmptyCartMessageIsShown fromPageHome(List<String> rowExcel) {
        return new TheEmptyCartMessageIsShown(rowExcel);
    }
}
