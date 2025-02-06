package Insider.pages;


import Insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//img[@alt='insider_logo']")
    public WebElement InsiderLogo;

    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement AcceptCookie;



}
