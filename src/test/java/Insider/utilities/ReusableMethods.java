package Insider.utilities;


import org.openqa.selenium.*;

import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
public class ReusableMethods {
    //HARD WAIT METHOD
    public static void waitForSecond(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //SwitchToWindow2
    public static void window(int sayi) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }



    //Tüm Sayfa ScreenShot
    public static void screenShot(String name) {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/Insider/testOutputs/screenshots/" + name + date + ".png";
        try {
            Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void   screenShotOfWebElement(WebElement webElement){
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/Insider/testOutputs/webElementScreenshots/" +  date + ".png";
        try {
            Files.write(  Paths.get(dosyaYolu) , webElement.getScreenshotAs(OutputType.BYTES) );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Click Method

    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public static void controlJobsList(String cssSelector, String value){
        List<WebElement> JobsControl = Driver.getDriver().findElements(By.cssSelector(cssSelector));

        for (WebElement w : JobsControl){

           if (!(w.getText().contains(value))){
               ReusableMethods.screenShotOfWebElement(w);

           }
            Assert.assertTrue(w.getText().contains(value));

        }

    }

    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }





}
