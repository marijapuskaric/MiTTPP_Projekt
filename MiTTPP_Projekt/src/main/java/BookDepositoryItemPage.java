import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BookDepositoryItemPage {
    WebDriver driver;
    By testText = By.xpath("/html/body/div[2]/div[6]/div[3]/div/div[1]/div[1]/div[2]/h1");
    By addBtn = By.xpath("/html/body/div[2]/div[6]/div[3]/div/div[1]/div[1]/div[3]/div/div[3]/a[1]");
    By addTestText = By.xpath("/html/body/div[12]/div/div/div[1]/h3");
    By basketBtn = By.xpath("/html/body/div[12]/div/div/div[2]/div/div[1]/a[2]");
    By currencyOption = By.xpath("//*[@id=\"selectCurrency\"]");
    By usdOption = By.xpath("//*[@id=\"selectCurrency\"]/option[3]");
    By testCurrency = By.xpath("/html/body/div[2]/div[6]/div[3]/div/div[1]/div[1]/div[3]/div/div[2]/div/div[3]/div/span[1]");
    public BookDepositoryItemPage (WebDriver driver)
    {
        this.driver = driver;
    }
    public void checkText (String text)
    {
        Assert.assertEquals(driver.findElement(testText).getText(), text);
        System.out.print(driver.findElement(testText).getText());
    }
    public void addItemToBasket (String text) throws InterruptedException
    {
        driver.findElement(addBtn).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(addTestText).getText(), text);
        driver.findElement(basketBtn).click();
    }

    public void changeCurrency(String text)
    {
        driver.findElement(currencyOption).click();
        driver.findElement(usdOption).click();
        Assert.assertEquals(driver.findElement(testCurrency).getText(), text);
        System.out.print(driver.findElement(testCurrency).getText());
    }
}
