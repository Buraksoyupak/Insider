package Insider.pages;

import Insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage {
    public CompanyPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains(text(),'Company')]")
    public WebElement CompanyLink;

    @FindBy(xpath = "//a[contains(text(),'Career')]")
    public WebElement CareerLink;

    @FindBy(xpath = "//div[@class='col-12 d-flex flex-wrap']")
    public WebElement OurLocations;

    @FindBy(xpath = "//*[contains(text(),'See all teams')]")
    public WebElement SeeAllTeams;

    @FindBy(xpath = "//*[contains(text(),'Life at Insider')]")
    public WebElement LifeAtInsider;










}
