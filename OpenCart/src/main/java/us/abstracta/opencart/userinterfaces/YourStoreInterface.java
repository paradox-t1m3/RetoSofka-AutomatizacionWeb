package us.abstracta.opencart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class YourStoreInterface {
    private YourStoreInterface() {//constructor empty
    }

    public static final Target LBL_TITLE_YOUR_STORE = Target.the("Label title page your store").locatedBy("//div[@id='logo']");
    public static final Target INFO_BNR = Target.the("Banner information").locatedBy("//div[@id='slideshow0']");
    public static final Target LST_BTN_ADD_TO_CART = Target.the("List Button add to cart").locatedBy("//div[@class='button-group']//button[contains(@onclick,'cart.add')]");
    public static final Target BTN_ADD_TO_CART = Target.the("Button add to cart").locatedBy("(//div[@class='button-group']//button[contains(@onclick,'cart.add')])[{0}]");
    public static final Target BTN_CART = Target.the("Button cart").locatedBy("//div[@id='cart']//button");
    public static final Target LBL_CART_TOTAL_ITEMS = Target.the("Cart total items").locatedBy("//span[@id='cart-total']");
    public static final Target BTN_CART_CHECKOUT = Target.the("Button Link checkout cart").locatedBy("//strong[text()=' Checkout']");
}
