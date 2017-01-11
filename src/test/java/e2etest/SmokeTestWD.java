package e2etest;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import utils.Driver;

public class SmokeTestWD extends BaseTest{

    @Test
    public void checkAgain(){
        Driver.initialise();
        SearchPage.goTo();
        SearchPage.isPageLoaded();
    }

    @Test
    public void checkSearchPage(){
        Driver.initialise();
        HomePage.goTo();
        HomePage.isPageLoaded();
    }


}
