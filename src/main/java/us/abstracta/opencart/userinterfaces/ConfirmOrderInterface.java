package us.abstracta.opencart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/**
 * UI locator for the order confirmation success message.
 */

public class ConfirmOrderInterface {
    private ConfirmOrderInterface() {//constructor empty
    }
    public static final Target LBL_TITLE_SUCCESS = Target.the("Label title success").locatedBy("//div[@id='content']//h1");
}
