package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageElements {
    WebDriver driver;
    @FindBy(xpath = "//a[@id='translation-btn']")
    private WebElement translationBtn;

    @FindBy(xpath = "//div[@id='country']")
    private WebElement countriesEnglishList;


    @FindBy(css = "div[id='currency-classic'] b")
    private WebElement monthlyPrice;

    @FindBy(xpath = "//span")
    private WebElement country;

    @FindBy(xpath = "//div[@class='trial-cost']")
    private WebElement currency;

    @FindBy(css =".plan-section>div:nth-child(4)>div:nth-child(2)>div:nth-child(2)>img")
    private WebElement hasDiscovery;
    @FindBy(css =".plan-section>div:nth-child(4)>div:nth-child(2)>div:nth-child(2)")
    private WebElement hasDiscoveryText;
    @FindBy(css =".plan-section>div:nth-child(5)>div:nth-child(2)>div:nth-child(2)>img")
    private WebElement has7daysTrail;

    @FindBy(css =".plan-section>div:nth-child(5)>div:nth-child(2)>div:nth-child(2)")
    private WebElement has7daysTrailText;

    @FindBy(css =".plan-section>div:nth-child(6)>div:nth-child(2)>div:nth-child(2)")
    private WebElement videoQuality;

    @FindBy(css =".plan-section>div:nth-child(7)>div:nth-child(2)>div:nth-child(2)")
    private WebElement deviceAccess;

    @FindBy(css =".plan-section>div:nth-child(8)>div:nth-child(2)>div:nth-child(2)")
    private WebElement rewindContent;

    @FindBy(css =".plan-section>div:nth-child(9)>div:nth-child(2)>div:nth-child(2)>img")
    private WebElement watchOffline;

    @FindBy(css =".plan-section>div:nth-child(10)>div:nth-child(2)>div:nth-child(2)")
    private WebElement watchSimultaneously;
    @FindBy(css =".plan-section>div:nth-child(11)>div:nth-child(2)>div:nth-child(2)>img")
    private WebElement castTV;
    @FindBy(css =".plan-section.extensions>div:nth-child(2)>div:nth-child(2)>div:nth-child(2)")
    private WebElement discoveryPlus;

    @FindBy(css =".plan-section.extensions>div:nth-child(3)>div:nth-child(2)>div:nth-child(2)")
    private WebElement fightSport;

    //-----Lite price Elements ------//
    @FindBy(css ="div[id='currency-lite'] b")
    private WebElement litePrice;


    //-----Premium price Elements ------//

    @FindBy(css ="div[id='currency-premium'] b")
    private WebElement PremiumPrice;

    public homePageElements(WebDriver driver) {
        // call parent constctor
        this.driver = driver; // current instance object
        //catch driver from test i will assign driver from test to here
        PageFactory.initElements(driver, this); // setup all  locaters defined  find by driver auto
    }

    public WebElement translationBtnElement() {
        return translationBtn;
    }
    public WebElement countriesEnglishListElement() {
        return countriesEnglishList;
    }
    public WebElement monthlyPriceElement() {
        return monthlyPrice;
    }

    public WebElement countryElement() {
        return country;
    }

    public WebElement currencyElement() {
        return currency;
    }

    public WebElement getHasDiscovery() {
        return hasDiscovery;
    }
    public WebElement getHasDiscoveryText() {
        return hasDiscoveryText;
    }
    public WebElement getHas7daysTrail() {
        return has7daysTrail;
    }

    public WebElement getHas7daysTrailText() {
        return has7daysTrailText;
    }

    public WebElement getVideoQuality() {
        return videoQuality;
    }
    public WebElement getDeviceAccess() {
        return deviceAccess;
    }
    public WebElement getRewindContent() {
        return rewindContent;
    }
    public WebElement getWatchOffline() {
        return watchOffline;
    }
    public WebElement getWatchSimultaneously() {
        return watchSimultaneously;
    }
    public WebElement getCastTV() {
        return castTV;
    }
    public WebElement getDiscoveryPlus() {
        return discoveryPlus;
    }
    public WebElement getFightSport() {
        return fightSport;
    }

    public WebElement getLitePrice() {
        return litePrice;
    }

    public WebElement getPremiumPrice() {
        return PremiumPrice;
    }
}
