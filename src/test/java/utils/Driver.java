package utils;

import io.github.bonigarcia.wdm.MarionetteDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;

    public static WebDriver initialise() {
        if (null == driver){
            MarionetteDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
            return driver;
        }
        return driver;
    }

    public static WebDriver instance(){
        return driver;
    }

    public static void quit() {
        driver.quit();
    }
}
