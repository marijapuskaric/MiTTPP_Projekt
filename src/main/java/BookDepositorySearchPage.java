import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BookDepositorySearchPage {
    WebDriver driver;
    public WebDriverWait wait;

    By books = By.xpath("/html/body/div[2]/div[6]/div[4]/div[4]/div/div/div/div/div[1]/div[1]/a/img");
    By testText = By.xpath("/html/body/div[2]/div[6]/div[4]/h1");
    public BookDepositorySearchPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private void clickThrough(List<By> bys)
    {
        wait = new WebDriverWait(driver, 30);
        for (By by : bys)
        {
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        }
    }

    public void chooseItem ()
    {
        this.clickThrough(new ArrayList<By>() {{
            add(books);
        }});
    }

    public void checkText (String text)
    {
        Assert.assertEquals(driver.findElement(testText).getText(), text);
        System.out.print(driver.findElement(testText).getText());
    }
}
