package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.HomePage;
import page.SearchPage;

public class ValidatePriceDisplayedOnTwoPages {

    static String costSearchPage;
    static String costDetailsPage;

    WebDriver driver;
    private HomePage homePage;
    private SearchPage searchPage;

    public ValidatePriceDisplayedOnTwoPages(BrowserInit browser){
        this.driver=browser;
        homePage=new HomePage(browser);
        searchPage=new SearchPage(browser);

    }

    @Given("^User click on second search$")
    public void userClickOnSecondSearch() throws Throwable {
        homePage.navigateUrl();
        homePage.inputSearchBox.sendKeys("Morgantown, WV");
        homePage.inputSearchBox.sendKeys(Keys.ENTER);
        costSearchPage=driver.findElement(By.xpath("//div[contains(@id,'srp-list')]//li[2]//span[contains(@class,'data-price-display')]")).getText();
        driver.findElement(By.xpath("//div[contains(@id,'srp-list')]//li[2]//div[contains(@class,'srp-item-address ellipsis')/a")).click();
        costDetailsPage=driver.findElement(By.xpath("//div[contains(@class,'price')]span[contains(@)(@itemprop,'price')]")).getText();

        throw new PendingException();
    }

    @Then("^price on searchResult page is same as viewDetails page$")
    public void priceOnSearchResultPageIsSameAsViewDetailsPage() throws Throwable {

        Assert.assertEquals(costDetailsPage,costSearchPage);
        throw new PendingException();
    }
}
