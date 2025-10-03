package us.abstracta.opencart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutInterface {
    private CheckoutInterface() {//constructor empty
    }
    public static final Target LBL_TITLE_CHECKOUT = Target.the("Label title checkout").locatedBy("//div[@id='content']//h1");
    public static final Target LST_RDB_NEW_CUSTOMER = Target.the("List Radio button new customer").locatedBy("//div[@id='collapse-checkout-option']//following::div[@class='radio']//label");
    public static final Target RDB_NEW_CUSTOMER = Target.the("Radio button new customer").locatedBy("(//div[@id='collapse-checkout-option']//following::label//input)[{0}]");
    public static final Target BTN_CONTINUE_NEW_CUSTOMER = Target.the("Button continue new customer").locatedBy("//input[@id='button-account']");

    public static final Target TXT_FIRST_NAME = Target.the("Text first name").locatedBy("//input[@id='input-payment-firstname']");
    public static final Target TXT_LAST_NAME = Target.the("Text last name").locatedBy("//input[@id='input-payment-lastname']");
    public static final Target TXT_EMAIL = Target.the("Text email").locatedBy("//input[@id='input-payment-email']");
    public static final Target TXT_TELEPHONE = Target.the("Text telephone").locatedBy("//input[@id='input-payment-telephone']");
    public static final Target TXT_ADDRESS_1 = Target.the("Text address 1").locatedBy("//input[@id='input-payment-address-1']");
    public static final Target TXT_CITY = Target.the("Text city").locatedBy("//input[@id='input-payment-city']");
    public static final Target TXT_CODE_POSTAL = Target.the("Text code postal").locatedBy("//input[@id='input-payment-postcode']");

    public static final Target DDL_COUNTRY = Target.the("Drop down list country").locatedBy("//select[@id='input-payment-country']");
    public static final Target LST_COUNTRY = Target.the("List of countries").locatedBy("//select[@id='input-payment-country']//option");
    public static final Target ITM_COUNTRY = Target.the("Item select country").locatedBy("(//select[@id='input-payment-country']//option)[{0}]");

    public static final Target DDL_REGION_STATE = Target.the("Drop down list region state").locatedBy("//select[@id='input-payment-zone']");
    public static final Target LST_REGION_STATE = Target.the("List of region state").locatedBy("//select[@id='input-payment-zone']//option");
    public static final Target ITM_REGION_STATE = Target.the("Item select region state").locatedBy("(//select[@id='input-payment-zone']//option)[{0}]");

    public static final Target BTN_CONTINUE_YOUR_PERSONAL_DETAILS = Target.the("Button your personal details").locatedBy("//input[@id='button-guest']");

    public static final Target BTN_DELIVERY_METHOD = Target.the("Button delivery method").locatedBy("//input[@id='button-shipping-method']");
    public static final Target TXA_COMMENTS_ABOUT_ORDER_DELIVERY_METHOD = Target.the("Text area comments about order delivety method").locatedBy("//textarea[@name='comment']");

    public static final Target CHK_ACCEPT_TERM_AND_CONDITIONS = Target.the("Checkbox accept terms and conditions").locatedBy("//input[@name='agree']");
    public static final Target BTN_PAYMENT_METHOD = Target.the("Button peyment method").locatedBy("//input[@id='button-payment-method']");

    public static final Target BTN_CONFIRM_ORDER = Target.the("Button confirm order").locatedBy("//input[@id='button-confirm']");


}
