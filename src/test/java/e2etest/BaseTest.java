package e2etest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;

public class BaseTest {

    @BeforeTest
    public void init() {
        Driver.initialise();
    }

    @AfterTest
    public static void close() {
        Driver.quit();
    }


}
