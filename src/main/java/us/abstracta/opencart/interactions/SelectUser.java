package us.abstracta.opencart.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class SelectUser implements Interaction {
    private Target listUsers;
    private Target selectUser;
    private String nameTypeUser;

    public SelectUser(Target listUsers, Target selectUser, String nameTypeUser) {
        this.listUsers = listUsers;
        this.selectUser = selectUser;
        this.nameTypeUser = nameTypeUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listNeCustomer = listUsers.resolveAllFor(actor);
        int newCustomer = 1;
        for (int i = 0; i < listNeCustomer.size(); i++) {
            if (listNeCustomer.get(i).getText().equals(nameTypeUser)) {
                actor.attemptsTo(Click.on(selectUser.of(String.valueOf(newCustomer))));
            } else newCustomer++;
        }
    }

    public static SelectUser fromList(Target listUsers, Target selectUser, String nameTypeUser) {
        return Tasks.instrumented(SelectUser.class,listUsers,selectUser,nameTypeUser);
    }
}
