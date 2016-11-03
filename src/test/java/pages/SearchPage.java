package pages;


import org.openqa.selenium.WebDriver;
import utils.Driver;

public class SearchPage {
    private static boolean pageLoaded;

    private static WebDriver driver;
    public static void goTo() {
         driver = Driver.instance();
        driver.get("http://localhost:8901/");

    }

    public static boolean isPageLoaded() {
        return pageLoaded;
    }
}
