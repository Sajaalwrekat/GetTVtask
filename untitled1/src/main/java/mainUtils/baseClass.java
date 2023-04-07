package mainUtils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class baseClass extends Thread {
    public static WebDriver driver;
    public static String driverPath = System.getProperty("user.dir");
    //public static String browserType;
    //public static String[] browserSelection = {"Chrome", "FireFox", "IE"};
    public static String defaultUrl = "https://subscribe.jawwy.tv/jo-en";

    @BeforeClass
    public void settingTest() throws FileNotFoundException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driverSettings("Chrome");
        navigateToURL(defaultUrl);
    }

    public WebDriver driverSettings(String browserType) {
        // if (driver == null) {
        if (browserType == "Chrome") {//For chrome driver call
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\s.alwraikat\\seleniumTest\\untitled1\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",driverPath+ "\\chromedriver.exe");
            driver = new ChromeDriver();
            //ChromeOptions options = new ChromeOptions();
           // options.addArguments("--remote-allow-origins=*");
          //  driver = new ChromeDriver(options);

        }

        if (browserType == "FireFox") {//For firefox driver call
            System.setProperty("webdriver.gecko.driver", driverPath + "\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        if (browserType == "Edge") {
            System.setProperty("webdriver.edge.driver", driverPath + "\\resources\\geckodriver.exe");
            driver = new EdgeDriver();
        }
        return driver;
    }

    public void navigateToURL(String url) {
        driver.navigate().to(url); //Navigate to the entered url in the top
        driver.manage().window().maximize(); //Enlarge the browser page
    }
/*
    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;

    }*/

    //Add listener For success case
    //Add listener For Failed case
    //Add screenshot For Failed case
    //Add test report generator
}


