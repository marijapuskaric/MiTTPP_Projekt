import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDepositoryBestsellerPage {
    WebDriver driver;
    By priceRangeOption = By.xpath("//*[@id=\"filterPrice\"]");
    By priceUnder20 = By.xpath("//*[@id=\"filterPrice\"]/option[2]");
    By refineResultsBtn = By.xpath("/html/body/div[2]/div[6]/div[1]/div/div/form/div[6]/button");
    public BookDepositoryBestsellerPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void filterBestsellers ()
    {
        driver.findElement(priceRangeOption).click();
        driver.findElement(priceUnder20).click();
        driver.findElement(refineResultsBtn).click();
    }

}
