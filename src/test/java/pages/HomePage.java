package pages;

import utils.Driver;
import org.openqa.selenium.WebDriver;

public class HomePage {

    static WebDriver driver;
    private static boolean pageLoaded;

    public static void goTo() {
        driver = Driver.instance();
        driver.get("http://localhost:8901/");
    }


    public static boolean isPageLoaded() {
        return pageLoaded;
    }
}
