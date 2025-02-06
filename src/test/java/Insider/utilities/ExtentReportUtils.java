package Insider.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ExtentReportUtils {
    private static ExtentReports extentReports;
    private static ExtentHtmlReporter extentHtmlReporter;
    private static ExtentTest extentTest;


    public static void setUpExtentReport(String reportName) {
        if (extentReports == null) {

            extentReports = new ExtentReports();


            String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
            String path = "target/extentReport/" + reportName + " " + date + " htmlReport.html";
            extentHtmlReporter = new ExtentHtmlReporter(path);


            extentReports.attachReporter(extentHtmlReporter);


            extentHtmlReporter.config().setDocumentTitle("Insider");


            extentHtmlReporter.config().setReportName(reportName);



            extentReports.setSystemInfo("<span style='color:blue; font-weight:bold'><i class='fa fa-server'></i> Environment:</span>", " QA");
            extentReports.setSystemInfo("<span style='color:green; font-weight:bold'><i class='fa fa-chrome'></i> Browser:</span>", " Chrome");
            extentReports.setSystemInfo("<span style='color:purple; font-weight:bold'><i class='fa fa-user'></i> Test Automation Engineer:</span>", " Burak Soyupak");

        }
    }


    public static void createExtentTest(String testName, String description) {
        extentTest = extentReports.createTest("<span style='color:blue; font-weight:bold'> " + testName + " </span>", "<span style='color:blue; font-weight:bold'> " + description + " </span>");
    }


    public static void extentTestPass(String message) {
        if (extentTest != null) {
            extentTest.pass(message);
        }
    }


    public static void extentTestFail(String message) {
        if (extentTest != null) {
            extentTest.fail(message);
        }
    }


    public static void extentTestInfo(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }


    public static void addScreenShotToReport() {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src\\test\\java\\Insider\\testOutputs\\webElementScreenshots\\screenShots" + date + ".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        try {
            Files.write(Paths.get(path), ts.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\" + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void addScreenShotOfWebElementToReport(WebElement webElement) {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src\\test\\java\\Insider\\testOutputs\\webElementScreenshots" + date + ".png";
        try {
            Files.write(Paths.get(path), webElement.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\" + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void extentTestSkip(String message) {
        if (extentTest != null) {
            extentTest.skip(message);
        }
    }



    public static void flush() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
