package Insider.tests;


import Insider.pages.CompanyPage;
import Insider.pages.HomePage;
import Insider.utilities.ConfigReader;
import Insider.utilities.Driver;
import Insider.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompanyPageTest {

    @Test
    public void companyPageTest() {

        Driver.getDriver().get(ConfigReader.getProperty("InsiderUrl"));


        HomePage homePage = new HomePage();
        homePage.AcceptCookie.click();

        CompanyPage companyPage = new CompanyPage();
        companyPage.CompanyLink.click();
        companyPage.CareerLink.click();


        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("career"));

        ReusableMethods.waitForSecond(2);
        ReusableMethods.scroll(companyPage.OurLocations);
        Assert.assertTrue(companyPage.OurLocations.isDisplayed());

        ReusableMethods.waitForSecond(2);
        ReusableMethods.scroll(companyPage.SeeAllTeams);
        Assert.assertTrue(companyPage.SeeAllTeams.isDisplayed());

        ReusableMethods.waitForSecond(2);
        ReusableMethods.scroll(companyPage.LifeAtInsider);
        Assert.assertTrue(companyPage.LifeAtInsider.isDisplayed());

    }

    
}
