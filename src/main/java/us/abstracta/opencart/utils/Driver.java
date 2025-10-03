package us.abstracta.opencart.utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import us.abstracta.opencart.enums.DriverEnum;

public class Driver {
    private Driver(){
    }

    @Getter
    private static WebDriver driverBrowser;

    public static WebDriver onUrl(String url, String navegador){
        driverBrowser = DriverEnum.driverEnum(navegador).execute();
        driverBrowser.get(url);
        return driverBrowser;
    }
}
