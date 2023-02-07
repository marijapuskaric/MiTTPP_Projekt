import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BookDepositoryCheckoutPage {
    WebDriver driver;
    By testText = By.xpath("//*[@id=\"ppp-main-content\"]/ol/li[1]");
    public BookDepositoryCheckoutPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void checkCheckout (String text)
    {
        Assert.assertEquals(driver.findElement(testText).getText(), text);
        System.out.print(driver.findElement(testText).getText());
    }
}
