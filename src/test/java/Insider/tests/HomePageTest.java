package Insider.tests;


import Insider.pages.HomePage;
import Insider.utilities.ConfigReader;
import Insider.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {

    @Test
    public void HomePageTest() {

        Driver.getDriver().get(ConfigReader.getProperty("InsiderUrl"));


        HomePage homePage = new HomePage();


        Assert.assertTrue(homePage.InsiderLogo.isDisplayed());


    }


}
