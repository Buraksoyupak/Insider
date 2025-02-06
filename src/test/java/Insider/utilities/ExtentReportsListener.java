package Insider.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class ExtentReportsListener implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {


    @Override
    public void onStart(ITestContext context) {
        ExtentReportUtils.setUpExtentReport(context.getCurrentXmlTest().getName());
    }


    @Override
    public void onTestStart(ITestResult result) {


        String testName = result.getMethod().getMethodName();

        String description = result.getMethod().getDescription();

        try {
            ExtentReportUtils.createExtentTest(description, testName);
        }catch (Exception e){

            ExtentReportUtils.createExtentTest(result.getName(), testName);
        }

    }


    @Override
    public void onTestSuccess(ITestResult result) {

        String passIsareti = "&#9989";
        ExtentReportUtils.extentTestPass("<span style='color:green; font-weight:bold'>"+result.getName()+" Testi başarıyla tamamlandı. </span>" + passIsareti);
    }


    @Override
    public void onTestFailure(ITestResult result) {

        String failIsareti = "&#10060";

        ExtentReportUtils.extentTestFail("<span style='color:red; font-weight:bold'>"+ result.getName()+" Testi başarısız oldu! </span>" + failIsareti);


        try {
            ExtentReportUtils.addScreenShotToReport();
        } catch (Exception e) {
            ExtentReportUtils.extentTestInfo("Rapora ekran görüntüsü eklenirken hata meydana geldi");
        } finally {
            Driver.closeDriver();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {

        String skipIsareti = "<img src='URL_TO_IMAGE' alt='skip_icon' style='width:16px;height:16px;'>";
        ExtentReportUtils.extentTestSkip("<span style='color:orange; font-weight:bold'> Hata nedeniyle Test atlandı! \n"+result.getName()+" testi tekrar calistirilacak</span>" + skipIsareti);


        try {
            ExtentReportUtils.addScreenShotToReport();
        } catch (Exception e) {
            ExtentReportUtils.extentTestInfo("Rapora ekran görüntüsü eklenirken hata meydana geldi");
        } finally {
            Driver.closeDriver();
        }
    }



    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtils.flush();
    }



    private static Map<String, Integer> retryCounts = new HashMap<>();


    private static final int maxRetryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        String testMethodName = result.getMethod().getMethodName();
        retryCounts.putIfAbsent(testMethodName, 0);
        int retryCount = retryCounts.get(testMethodName);  // Şu anki deneme sayısını alır.

        if (retryCount < maxRetryCount) {
            retryCount++;  // Deneme sayısını artırır.
            retryCounts.put(testMethodName, retryCount);  // Günceller.
            return true;  // Testi yeniden çalıştır.
        }
        return false;  // Test yeniden çalıştırılmayacak.
    }



    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(ExtentReportsListener.class);
    }
}
