package us.abstracta.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import us.abstracta.opencart.interactions.CompleteCheckoutInteraction;
import us.abstracta.opencart.interactions.SelectUser;
import us.abstracta.opencart.interactions.waits.WaitElementVisibleInteraction;

import java.util.List;

import static us.abstracta.opencart.userinterfaces.CheckoutInterface.*;

public class CheckoutProcessTask implements Task {
    private List<String> info;

    public CheckoutProcessTask(List<String> info) {
        this.info = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitElementVisibleInteraction.of(LBL_TITLE_CHECKOUT, 5));
        actor.attemptsTo(SelectUser.fromList(LST_RDB_NEW_CUSTOMER,RDB_NEW_CUSTOMER,info.get(0)));
        actor.attemptsTo(CompleteCheckoutInteraction.now());
    }

    public static CheckoutProcessTask execute(List<String> info) {
        return Tasks.instrumented(CheckoutProcessTask.class,info);
    }
}
