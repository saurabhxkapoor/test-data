package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver browser;

    public SearchPage(WebDriver driver){
        this.browser=driver;
        PageFactory.initElements(browser,this);
    }


    @FindBy(how= How.CLASS_NAME, using="search-result-count")
    public WebElement spanHomeCount;
}
