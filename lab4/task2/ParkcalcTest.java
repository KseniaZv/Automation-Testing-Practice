import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParkcalcTest {

    private WebDriver driver;
    private Select lotSelect;
    private WebElement timeFrom;
    private WebElement timeFromPm;
    private WebElement dateFrom;
    private WebElement timeTo;
    private WebElement timeToPmRb;
    private WebElement dateToInput;
    private WebElement calculateBtn;
    private WebElement costTxt;
    private By submitBy = By.xpath("//tr[./td/div[text()='COST']]/td/span[@class='SubHead']//b");

    @DataProvider(name="parkcalc")
    public Object[][] getData() {
        return new Object[][] {
                {"Valet Parking", "9:00", "04/28/2018", "11:00", "04/28/2018", "$ 12.00"},
                {"Economy Parking", "8:00", "04/28/2018", "1:00", "04/28/2018", "$ 9.00"},
                {"Short-Term Parking", "12:00", "04/28/2018", "1:00", "04/28/2018", "$ 2.00"},
                {"Long-Term Surface Parking", "12:00", "04/28/2018", "10:00", "04/28/2018", "$ 10.00"},
                {"Long-Term Garage Parking", "8:00", "04/28/2018", "11:00", "04/28/2018", "$ 6.00"}
        };
    }

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "E:\\Code\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://adam.goucher.ca/parkcalc/");
    }

    @BeforeMethod
    public void beforeMethod() {
        WebElement lot = driver.findElement(By.xpath("//select[@id='Lot']"));
        lotSelect = new Select(lot);
        timeFrom = driver.findElement(By.id("EntryTime"));
        timeFromPm = driver.findElement(By.xpath("//input[@name='EntryTimeAMPM' and @value='PM']"));
        dateFrom = driver.findElement(By.xpath("//input[@id='EntryDate']"));
        timeTo = driver.findElement(By.name("ExitTime"));
        timeToPmRb = driver.findElement(By.xpath("//input[@name='ExitTimeAMPM' and @value='PM']"));
        dateToInput = driver.findElement(By.xpath("//input[@id='ExitDate']"));
        calculateBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        costTxt = driver.findElement(By.xpath("//tr[./td/div[text()='COST']]/td/span[@class='SubHead']//b"));

    }

    @Test (dataProvider="parkcalc")
    public void testPostsPage(String lotSelectValue, String timeFromValue, String dateFromValue,
                              String timeToValue, String dateToInputValue, String expectedValue) throws InterruptedException {

        lotSelect.selectByVisibleText(lotSelectValue);
        timeFrom.clear();
        timeFrom.sendKeys(timeFromValue);
        timeFromPm.click();
        dateFrom.clear();
        dateFrom.sendKeys(dateFromValue);
        timeTo.clear();
        timeTo.sendKeys(timeToValue);
        timeToPmRb.click();
        dateToInput.clear();
        dateToInput.sendKeys(dateToInputValue);
        calculateBtn.click();
        costTxt = driver.findElement(submitBy);

        Assert.assertEquals(costTxt.getText(), expectedValue, "Cost value");
        Thread.sleep(10000);
    }

    @AfterTest
    public void close() {
        driver.close();
    }

}