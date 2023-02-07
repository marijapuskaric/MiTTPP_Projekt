import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BookDepositoryBasketPage {
    WebDriver driver;
    By checkoutBtn = By.xpath("/html/body/div[2]/div[6]/div/div[2]/div[2]/a[1]");
    public BookDepositoryBasketPage (WebDriver driver)
    {
        this.driver = driver;
    }
    public void goToCheckout ()
    {
        driver.findElement(checkoutBtn).click();
    }
}
