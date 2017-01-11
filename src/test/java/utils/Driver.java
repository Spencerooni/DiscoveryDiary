package utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.MarionetteDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;

    public static WebDriver initialise() {
        if (null == driver){
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
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
