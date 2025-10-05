package us.abstracta.opencart.utils;

/**
 * Global constants for URL, browser flags, and result keys.
 */

public class Constants {
    private Constants() {//constructor empty
    }
    public static final String URL = "https://opencart.abstracta.us/";
    public static final String IGNORE_CERTIFICATES_ERROR = "--ignore-certificate-errors";
    public static final String IGNORE_CERTIFICATES_ERROR_SSL = "--ignore-ssl-errors";
    public static final String REMOTE_ALLOW_ORIGINS = "--remote-allow-origins=*";
    public static final String RESULT = "resultTotal";
    public static final String RESULT_VIEW_MESSAGE_CART_EMPTY = "messageCartEmpty";
}
