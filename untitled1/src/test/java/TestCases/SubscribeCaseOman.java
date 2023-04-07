package TestCases;

import mainUtils.supportClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.homePageElements;

public class SubscribeCaseOman extends supportClass {

    supportClass supportClassObj = new supportClass();

    private homePageElements homePageElementsObject;

@BeforeClass
public void generalSetup() throws InterruptedException {
    homePageElementsObject = PageFactory.initElements(driver, homePageElements.class);
    supportClassObj.selectCountry("Oman");
    //get data for each country from support class to help us in assertion
    supportClassObj.packagesDataOman();

}

@BeforeMethod
public void testSetup() {
   // homePageElementsObject.translationBtnElement().click();

}

@Test
public void checkCurrenyPerCountry() throws InterruptedException {
    Thread.sleep(200);
    String currentCurrency= homePageElementsObject.currencyElement().getText();
    //should substring text to get currency value only OMR, TND, AED and do assertion, i do not have very much time to do :(
    if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
       System.out.println(currentCurrency);
        Assert.assertEquals(currentCurrency,"From 1.00 OMR/week");
    }
    if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
        System.out.println(currentCurrency);
        Assert.assertEquals(currentCurrency,"From 1.00 TND/week");
    }
    if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
        System.out.println(currentCurrency);
        Assert.assertEquals(currentCurrency,"From 10.00 AED/week");
    }
}
@Test
public  void classicPackagePerCountry() throws InterruptedException {
        Thread.sleep(200);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down to x , or until element x being viewed
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageElementsObject.monthlyPriceElement());
        Thread.sleep(500);
        //1. check monthly price for current selected country -- should create method under support class and call it here
        String priceMonthly = homePageElementsObject.monthlyPriceElement().getText();
        //String priceValue= homePageElementsObject.monthlyPriceElement().getText();
        System.out.println(priceMonthly);
        Thread.sleep(200);
       /* if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            Assert.assertEquals(priceMonthly,"10");
        }*/
        //OMAN PRICE CHECK
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            Assert.assertEquals(priceMonthly, "10");
        }
        /*//need extra time to get value itself not array
        String firstElement = arrayListOman.get(0).toString();
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            Assert.assertEquals(priceMonthly, firstElement);
        }*/
        //Tunisia Price Check
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
            Assert.assertEquals(priceMonthly,"3.4");
        }
        //UAE Price Check
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
            Assert.assertEquals( priceMonthly,"10.9");
        }

        Thread.sleep(200);
        //2. check hasDiscovery for country
        //OMAN has discovery Check
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageElementsObject.getHasDiscovery());
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,80)", "");

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            Boolean hasDiscovery=homePageElementsObject.getHasDiscovery().isDisplayed();
            //Boolean hasDiscovery= driver.findElement(By.cssSelector(".plan-section>div:nth-child(4)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertTrue( hasDiscovery, String.valueOf(true));
            System.out.println(hasDiscovery);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
            String hasDiscoveryText=homePageElementsObject.getHasDiscoveryText().getText();
            System.out.println(hasDiscoveryText);
           // String hasDiscovery= driver.findElement(By.cssSelector(".plan-section>div:nth-child(4)>div:nth-child(2)>div:nth-child(2)>img")).getText();
            Assert.assertEquals( hasDiscoveryText,"Available");
            System.out.println(hasDiscoveryText);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
            Boolean hasDiscovery=homePageElementsObject.getHasDiscovery().isDisplayed();
            //Boolean hasDiscovery= driver.findElement(By.cssSelector(".plan-section>div:nth-child(4)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertTrue( hasDiscovery, String.valueOf(true));
            System.out.println(hasDiscovery);
        }

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50)", "");
        Thread.sleep(200);
        //2. check 7days trails for country

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            Boolean has7daysTrail= homePageElementsObject.getHas7daysTrail().isDisplayed();
           //Boolean has7daysTrail= driver.findElement(By.cssSelector(".plan-section>div:nth-child(5)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertTrue(true, String.valueOf(has7daysTrail));
            System.out.println(has7daysTrail);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
            Boolean has7daysTrail= homePageElementsObject.getHas7daysTrail().isDisplayed();
            //String has7daysTrail= driver.findElement(By.cssSelector(".plan-section>div:nth-child(5)>div:nth-child(2)>div:nth-child(2)>img")).getText();
            Assert.assertTrue(true, String.valueOf(has7daysTrail));
            System.out.println(has7daysTrail);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
            Boolean has7daysTrail= homePageElementsObject.getHas7daysTrail().isDisplayed();
           // Boolean has7daysTrail= driver.findElement(By.cssSelector(".plan-section>div:nth-child(5)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertTrue(true, String.valueOf(has7daysTrail));
            System.out.println(has7daysTrail);
        }
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");

        //3. check video Quality trails for country
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50)", "");
        String videoQaulity= driver.findElement(By.cssSelector(".plan-section>div:nth-child(6)>div:nth-child(2)>div:nth-child(2)")).getText();

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            Assert.assertEquals(videoQaulity,"Full HD");
            System.out.println(videoQaulity);
        }
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
            //String videoQaulity= driver.findElement(By.cssSelector(".plan-section>div:nth-child(6)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(videoQaulity,"Full HD");
            System.out.println(videoQaulity);
        }
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
            //String videoQaulity= driver.findElement(By.cssSelector(".plan-section>div:nth-child(6)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(videoQaulity,"Full HD");
            System.out.println(videoQaulity);
        }


        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50)", "");
        String deviceAccess=homePageElementsObject.getDeviceAccess().getText();
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageElementsObject.getHasDiscovery());

        // 4. check Device Access for country
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
           // String deviceAccess= driver.findElement(By.cssSelector(".plan-section>div:nth-child(7)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(deviceAccess,"2");
            System.out.println(deviceAccess);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
            //String deviceAccess= driver.findElement(By.cssSelector(".plan-section>div:nth-child(7)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(deviceAccess,"4");
            System.out.println(deviceAccess);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
            //String deviceAccess= driver.findElement(By.cssSelector(".plan-section>div:nth-child(7)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(deviceAccess,"4");
            System.out.println(deviceAccess);
        }


        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50)", "");
        // 5. check Rewind content for country
        String rewindContent=homePageElementsObject.getRewindContent().getText();
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
           // String rewindContent= driver.findElement(By.cssSelector(".plan-section>div:nth-child(8)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(rewindContent,"For 7 days");
            System.out.println(rewindContent);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
            //String rewindContent= driver.findElement(By.cssSelector(".plan-section>div:nth-child(8)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(rewindContent,"For 7 days");
            System.out.println(rewindContent);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
            //String rewindContent= driver.findElement(By.cssSelector(".plan-section>div:nth-child(8)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(rewindContent,"For 7 days");
            System.out.println(rewindContent);
        }

        // 6. check watchOffline for country
        Boolean watchOffline=homePageElementsObject.getWatchOffline().isDisplayed();
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            //Boolean watchOffline= driver.findElement(By.cssSelector(".plan-section>div:nth-child(9)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertEquals(watchOffline,true);
            System.out.println(watchOffline);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
            //Boolean watchOffline= driver.findElement(By.cssSelector(".plan-section>div:nth-child(9)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertEquals(watchOffline,true);
            System.out.println(watchOffline);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
           // Boolean watchOffline= driver.findElement(By.cssSelector(".plan-section>div:nth-child(9)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertEquals(watchOffline,true);
            System.out.println(watchOffline);
        }


        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50)", "");
        String watchSimultaneously=homePageElementsObject.getWatchSimultaneously().getText();
        // 7. check Watch Simultaneously for country
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            //String watchSimultaneously= driver.findElement(By.cssSelector(".plan-section>div:nth-child(10)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(watchSimultaneously,"2 Devices");
            System.out.println(watchSimultaneously);
        }
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
           // String watchSimultaneously= driver.findElement(By.cssSelector(".plan-section>div:nth-child(10)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(watchSimultaneously,"2 Devices");
            System.out.println(watchSimultaneously);
        }
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
           // String watchSimultaneously= driver.findElement(By.cssSelector(".plan-section>div:nth-child(10)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(watchSimultaneously,"2 Devices");
            System.out.println(watchSimultaneously);
        }

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50)", "");

        // 8. check Cast to TV for country
        Boolean castTV=homePageElementsObject.getCastTV().isDisplayed();
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            //Boolean castTV= driver.findElement(By.cssSelector(".plan-section>div:nth-child(11)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertTrue(castTV, String.valueOf(true));
            System.out.println(castTV);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
           // Boolean castTV= driver.findElement(By.cssSelector(".plan-section>div:nth-child(11)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertTrue(castTV, String.valueOf(true));
            System.out.println(castTV);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
            //Boolean castTV= driver.findElement(By.cssSelector(".plan-section>div:nth-child(11)>div:nth-child(2)>div:nth-child(2)>img")).isDisplayed();
            Assert.assertTrue(castTV, String.valueOf(true));
            System.out.println(castTV);
        }

       // 9. Available Add-Ons 1 checking
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
        String discoveryPlus=homePageElementsObject.getDiscoveryPlus().getText();

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            //String castTV= driver.findElement(By.cssSelector(".plan-section.extensions>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(discoveryPlus,"Аvailable");
            System.out.println(castTV);
        }
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
            //String castTV= driver.findElement(By.cssSelector(".plan-section.extensions>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(discoveryPlus,"Аvailable");
            System.out.println(castTV);
        }
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
            //String castTV= driver.findElement(By.cssSelector(".plan-section.extensions>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(discoveryPlus,"Аvailable");
            System.out.println(castTV);
        }

       //  Available Add-Ons 2 checking
        String fightSport=homePageElementsObject.getFightSport().getText();
        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
            //String castTV= driver.findElement(By.cssSelector(".plan-section.extensions>div:nth-child(3)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(fightSport,"Аvailable");
            System.out.println(fightSport);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Tunisia")) {
           // String castTV= driver.findElement(By.cssSelector(".plan-section.extensions>div:nth-child(3)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(fightSport,"Аvailable");
            System.out.println(fightSport);
        }

        if (supportClassObj.getCurrentCountry().equalsIgnoreCase("UAE")) {
            //String castTV= driver.findElement(By.cssSelector(".plan-section.extensions>div:nth-child(3)>div:nth-child(2)>div:nth-child(2)")).getText();
            Assert.assertEquals(fightSport,"Аvailable");
            System.out.println(fightSport);
        }


    }

@Test
 public void checkLitePackagePerCountry() throws InterruptedException {
//sorry i do not have much time to do it, but it is same mechanism to classic test
    Thread.sleep(200);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    //scroll down to x , or until element x being viewed
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageElementsObject.getLitePrice());
    if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
        Assert.assertEquals(homePageElementsObject.getLitePrice().getText(), "5");
    }
}

@Test
public void checkPremiumPackagePerCountry() throws InterruptedException {
//sorry i do not have much time to do it, but it is same mechanism to classic test
    Thread.sleep(200);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    //scroll down to x , or until element x being viewed
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageElementsObject.getPremiumPrice());
    if (supportClassObj.getCurrentCountry().equalsIgnoreCase("Oman")) {
        Assert.assertEquals(homePageElementsObject.getPremiumPrice().getText(), "15");
    }
    }

@AfterClass
public void afterAllTest() {
    driver.quit();
}
}

