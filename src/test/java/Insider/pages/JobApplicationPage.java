package Insider.pages;


import Insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobApplicationPage {

    public JobApplicationPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[.='View Role']")
    public WebElement ViewRoleButton;





}
