package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidatePriceDisplayedOnTwoPages {

    WebDriver driver=new FirefoxDriver();
    WebDriverWait wait= new WebDriverWait(driver,30);
    static String costSearchPage;
    static String costDetailsPage;

    @Given("^User click on second search$")
    public void userClickOnSecondSearch() throws Throwable {
        costSearchPage=driver.findElement(By.xpath("//ul[contains(@class,'srp-list marginless-unstyled')]//li[2]//span[contains(@class,'data-price')]")).getText();
        driver.findElement(By.xpath("//ul[contains(@class,'srp-list marginless-unstyled']//li[2]//div[contains(@data-label,'property-address')/a")).click();
        costDetailsPage=driver.findElement(By.xpath("//div[contains(@class,'price')]span[contains(@)(@itemprop,'price')]")).getText();

        throw new PendingException();
    }

    @Then("^price on searchResult page is same as viewDetails page$")
    public void priceOnSearchResultPageIsSameAsViewDetailsPage() throws Throwable {

        Assert.assertEquals(costDetailsPage,costSearchPage);
        throw new PendingException();
    }
}
