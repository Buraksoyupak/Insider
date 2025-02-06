package Insider.pages;


import Insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerPage {

    public CareerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[contains(text(),'See all QA jobs')]")
    public WebElement SeeAllQAJobsLink;

    @FindBy(xpath= "//span[@title='Quality Assurance']")
    public WebElement ResultText;

    @FindBy(id = "select2-filter-by-location-container")
    public WebElement FindByLocation;

    @FindBy(id= "select2-filter-by-department-container")
    public WebElement FindByDepartment;

    @FindBy(xpath = "//li[contains(text(),'Istanbul')]")
    public WebElement IstanbulTurkeySelection;

    @FindBy(xpath= "//li[contains(text(),'Quality Assurance')]")
    public WebElement QASelection;

    @FindBy(id= "jobs-list")
    public WebElement JobsList;

    @FindBy(xpath= "//*[.='Filter by Location']")
    public WebElement VisibiltyForJobs;

















}
