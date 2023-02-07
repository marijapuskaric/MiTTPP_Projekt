import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BookDepositoryHomePage {
    WebDriver driver;
    By searchTextBox = By.name("searchTerm");
    By bestsellerBtn = By.xpath("/html/body/div[2]/div[4]/div/ul/li[2]/a");
    By advanceSearchBtn = By.xpath("/html/body/div[2]/div[2]/header/div[2]/div[4]/a");

    public BookDepositoryHomePage (WebDriver driver)
    {
        this.driver = driver;
    }
    public void searchBook(String title)
    {
        driver.findElement(searchTextBox).sendKeys(title);
        driver.findElement(searchTextBox).submit();
    }
    public void goToBestsellers()
    {
        driver.findElement(bestsellerBtn).click();
    }

    public void goToAdvanceSearch()
    {
        driver.findElement(advanceSearchBtn).click();
    }
}
