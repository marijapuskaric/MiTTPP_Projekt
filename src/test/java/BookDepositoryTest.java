import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BookDepositoryTest {
    public WebDriver driver;
    public String testURL = "https://www.bookdepository.com";
    public BookDepositoryHomePage objHomePage;
    public BookDepositorySearchPage objSearchPage;
    public BookDepositoryBestsellerPage objBestsellersPage;
    public BookDepositoryAdvancedSearchPage objAdvancedSearchPage;
    public BookDepositoryItemPage objItemPage;
    public BookDepositoryBasketPage objBasketPage;
    public BookDepositoryCheckoutPage objCheckoutPage;
    @BeforeMethod
    @Parameters("browser")

    public void init(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driverSetup(driver);
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                driverSetup(driver);
                break;
            default:
                driver = null;
                break;
        }
    }

    public void driverSetup(WebDriver driver)
    {
        driver.manage().window().maximize();
        driver.navigate().to(testURL);
        WebElement acceptCookies = driver.findElement(By.xpath("/html/body/div[1]/div[2]/button[1]"));
        acceptCookies.click();
    }
    @Test
    public void bookSearchTest() throws InterruptedException
    {
        Thread.sleep(5000);
        objHomePage = new BookDepositoryHomePage(driver);
        objHomePage.searchBook("the secret history");
        objSearchPage = new BookDepositorySearchPage(driver);
        objSearchPage.chooseItem();
        objItemPage = new BookDepositoryItemPage(driver);
        objItemPage.checkText("The Secret History : From the Pulitzer Prize-winning author of The Goldfinch");
        Thread.sleep(5000);
    }
    @Test
    public void checkoutTest() throws InterruptedException
    {
        Thread.sleep(5000);
        objHomePage = new BookDepositoryHomePage(driver);
        objHomePage.searchBook("the secret history");
        objSearchPage = new BookDepositorySearchPage(driver);
        objSearchPage.chooseItem();
        objItemPage = new BookDepositoryItemPage(driver);
        objItemPage.addItemToBasket("Item added to your basket");
        objBasketPage = new BookDepositoryBasketPage(driver);
        objBasketPage.goToCheckout();
        objCheckoutPage = new BookDepositoryCheckoutPage(driver);
        objCheckoutPage.checkCheckout("Payment details");
        Thread.sleep(5000);
    }
    @Test
    public void changeCurrencyTest() throws InterruptedException
    {
        Thread.sleep(5000);
        objHomePage = new BookDepositoryHomePage(driver);
        objHomePage.searchBook("the secret history");
        objSearchPage = new BookDepositorySearchPage(driver);
        objSearchPage.chooseItem();
        objItemPage = new BookDepositoryItemPage(driver);
        objItemPage.changeCurrency("US$13.29");
        Thread.sleep(5000);
    }
    @Test
    public void filterBestsellersTest() throws InterruptedException
    {
        Thread.sleep(5000);
        objHomePage = new BookDepositoryHomePage(driver);
        objHomePage.goToBestsellers();
        objBestsellersPage = new BookDepositoryBestsellerPage(driver);
        objBestsellersPage.filterBestsellers();
        Thread.sleep(5000);
    }
    @Test
    public void advancedSearch() throws InterruptedException
    {
        Thread.sleep(5000);
        objHomePage = new BookDepositoryHomePage(driver);
        objHomePage.goToAdvanceSearch();
        objAdvancedSearchPage = new BookDepositoryAdvancedSearchPage(driver);
        objAdvancedSearchPage.advancedSearch("chiltern");
        objSearchPage = new BookDepositorySearchPage(driver);
        objSearchPage.checkText("Books by chiltern");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void teardownTest()
    {
        driver.quit();
    }

}
