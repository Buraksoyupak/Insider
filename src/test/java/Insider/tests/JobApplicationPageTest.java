package Insider.tests;


import Insider.pages.CareerPage;
import Insider.pages.JobApplicationPage;
import Insider.utilities.ConfigReader;
import Insider.utilities.Driver;
import Insider.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobApplicationPageTest {

    @Test
    public void jobApplicationPageTest() {

        Driver.getDriver().get(ConfigReader.getProperty("InsiderOpenPositionsUrl"));


        JobApplicationPage jobApplicationPage = new JobApplicationPage();
        CareerPage careerPage = new CareerPage();

        ReusableMethods.scroll(careerPage.ResultText);

        careerPage.FindByLocation.click();
        ReusableMethods.waitForSecond(1);
        careerPage.IstanbulTurkeySelection.click();

        careerPage.FindByDepartment.click();
        ReusableMethods.waitForSecond(1);
        careerPage.QASelection.click();

        ReusableMethods.scroll(careerPage.VisibiltyForJobs);
        ReusableMethods.click(jobApplicationPage.ViewRoleButton);

        ReusableMethods.window(1);

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("jobs.lever"));




    }


}
