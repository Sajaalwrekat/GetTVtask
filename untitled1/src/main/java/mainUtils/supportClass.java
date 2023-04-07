package mainUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.homePageElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class supportClass extends baseClass {

    public supportClass() {
        this.driver = driver;
    }

    private homePageElements homePageElementsObject;
    public static ArrayList<List> arrayListOman = new ArrayList<>();

    public static Boolean[] classicPackgeOmanBooleanData;

    public void selectCountry(String country) throws InterruptedException {
        homePageElementsObject = PageFactory.initElements(driver, homePageElements.class);
        homePageElementsObject.countriesEnglishListElement().click();
        Thread.sleep(2000);
        if (country == "Tunisia") {
            driver.findElement(By.xpath("//span[@id='tn-contry-lable']")).click();
        }
        if (country == "UAE") {
            driver.findElement(By.xpath("//span[@id='ae-contry-lable']")).click();
        }
        if (country == "Oman") {
            driver.findElement(By.xpath("//span[@id='om-contry-lable']")).click();
        }

    }

    public String getCurrentCountry() {
        String currentCountryNow = driver.findElement(By.cssSelector("#country-name")).getText();
        return currentCountryNow;
    }


    public void packagesDataOman() {
        // select any adding data technique  for each country Array,or object, or Map, or files, to pass it for assertion method in test cases i do not have much time to that sorry :(
        arrayListOman.add(Arrays.asList("10"));
        arrayListOman.add(Arrays.asList(true));
        arrayListOman.add(Arrays.asList(true));
        arrayListOman.add(Arrays.asList("Full HD"));
        arrayListOman.add(Arrays.asList("2"));
        arrayListOman.add(Arrays.asList("For 7 days"));
        arrayListOman.add(Arrays.asList(true));
        arrayListOman.add(Arrays.asList("2 Devices"));
        arrayListOman.add(Arrays.asList(true));
        arrayListOman.add(Arrays.asList("Аvailable"));
        arrayListOman.add(Arrays.asList("Аvailable"));
    }

    public void changeCountryLoop(){


    }
}