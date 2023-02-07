import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDepositoryAdvancedSearchPage {
    WebDriver driver;
    By publisherInput = By.xpath("/html/body/div[2]/div[6]/div/form/div[2]/div[1]/div/input");
    By searchBtn = By.xpath("/html/body/div[2]/div[6]/div/form/div[3]/div/div/button");
    public BookDepositoryAdvancedSearchPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void advancedSearch(String publisher)
    {
        driver.findElement(publisherInput).sendKeys(publisher);
        driver.findElement(searchBtn).click();
    }
}
