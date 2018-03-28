package steps;

import page.HomePage;
import page.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchByLocation {

    WebDriver driver;
    private HomePage homePage;
    private SearchPage searchPage;

    public SearchByLocation(BrowserInit browser){
        this.driver=browser;
        homePage=new HomePage(browser);
        searchPage=new SearchPage(browser);

    }
   // Actions builder=new Actions(driver);
    //WebDriverWait wait=new WebDriverWait(driver,30);
    @Given("^User navigate to realtor website$")
    public void userNavigateToRealtorWebsite() throws Throwable {

        homePage.navigateUrl();
        //Assert.assertEquals(driver.getTitle(),"");
    }


    @When("^Location entered <town> in searchBox$")
    public void locationEnteredTownInSearchBox() throws Throwable {
        homePage.inputSearchBox.sendKeys("Morgantown, WV");
        homePage.inputSearchBox.sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@id,'page-title')][contains(text(),'Homes for Sale']")));

    }


    @Then("^Relevant listing result more than zero$")
    public void relevantListingResultMoreThanZero() throws Throwable {
        String homeCounts= searchPage.spanHomeCount.getText();
        String[] countArray=homeCounts.split(" ");
        int countInNo=Integer.parseInt(countArray[0]);
        Assert.assertTrue((countInNo>0));
    }
}
