package Insider.tests;



import Insider.pages.CareerPage;
import Insider.pages.HomePage;
import Insider.utilities.*;

import org.testng.Assert;
import org.testng.annotations.Test;



public class CareerPageTest {

    @Test()
    public void careerPageTest() {



        Driver.getDriver().get(ConfigReader.getProperty("InsiderCareerQAUrl"));

        HomePage homePage = new HomePage();
        homePage.AcceptCookie.click();
        ExtentReportUtils.extentTestInfo("Cookie accept edildi");

        CareerPage careerPage = new CareerPage();
        careerPage.SeeAllQAJobsLink.click();

        ReusableMethods.scroll(careerPage.ResultText);

        careerPage.FindByLocation.click();
        ReusableMethods.waitForSecond(1);
        careerPage.IstanbulTurkeySelection.click();
        ExtentReportUtils.extentTestInfo("Istanbul, Turkey Secildi");

        careerPage.FindByDepartment.click();
        ReusableMethods.waitForSecond(1);
        careerPage.QASelection.click();
        ExtentReportUtils.extentTestInfo("Quality Assurance Secildi");

        ReusableMethods.scroll(careerPage.JobsList);
        Assert.assertTrue(careerPage.JobsList.isDisplayed());
        ExtentReportUtils.extentTestPass("İsler Listesinin Varligi Kontrol Edildi");

        ReusableMethods.scroll(careerPage.VisibiltyForJobs);

        ReusableMethods.waitForSecond(2);

        ReusableMethods.controlJobsList(ConfigReader.getProperty("IstanbulTurkeyJobsControl"),"Istanbul, Turkey");
        ExtentReportUtils.extentTestPass("Filtrelenen Islerin Istanbul, Turkey Icerdigi Dogrulandı");

        ReusableMethods.controlJobsList(ConfigReader.getProperty("QualityAssuranceJobsControl"),"Quality Assurance");
        ExtentReportUtils.extentTestPass("Filtrelenen Islerin Quality Assurance Icerdigi Dogrulandı");

        /*
        Bu kısımda pozisyon QA olarak geçtiği için ve bize verilen gereksinimlerde
        Quality Assurance olarak kontrol etmemiz istendigi icin hata alınmakta ve ilgili
        WebElementin ekran goruntusu testOutputs altına otomatik gelmektedir ayrıca target/extentReport a eklenmistir
         */
        ReusableMethods.controlJobsList(ConfigReader.getProperty("PositionJobsControl"),"Quality Assurance");
        ExtentReportUtils.extentTestFail("Filtrelenen Islerin Birinde Quality Assurance Yerine QA Gectigi Icin Fail Alindi");






    }


}
