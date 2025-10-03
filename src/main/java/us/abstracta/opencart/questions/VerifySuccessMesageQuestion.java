package us.abstracta.opencart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.conditions.Check;
import us.abstracta.opencart.interactions.waits.WaitMomentInteraction;

import static us.abstracta.opencart.userinterfaces.ConfirmOrderInterface.*;
import static us.abstracta.opencart.utils.Constants.*;

public class VerifySuccessMesageQuestion implements Question<Boolean> {

    private String message;

    public VerifySuccessMesageQuestion(String message) {
        this.message = message;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitMomentInteraction.pauseForSeconds(1));
        actor.attemptsTo(Check.whether(message.equals(LBL_TITLE_SUCCESS.resolveFor(actor).getText()))
                .andIfSo(RememberThat.theValueOf(RESULT).is(true))
                .otherwise(RememberThat.theValueOf(RESULT).is(false)));


        return actor.recall(RESULT);
    }

    public static VerifySuccessMesageQuestion displayed(String info){
        return new VerifySuccessMesageQuestion(info);
    }
}
