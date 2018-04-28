import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest {

    private WebDriver driver;
    private Select countrySelect;
    private Select monthSelect;
    private Select daySelect;
    private Select yearSelect;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement maritalStatus;
    private WebElement hobby;
    private WebElement hobby2;
    private WebElement phoneNumber;
    private WebElement username;
    private WebElement email;
    private WebElement profilePicture;
    private WebElement aboutYourself;
    private WebElement password;
    private WebElement confirmPassword;
    private WebElement submitButton;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "E:\\Code\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demoqa.com/registration/");
    }

    @BeforeMethod
    public void beforeMethod() {
        WebElement country = driver.findElement(By.xpath("//select[@id='dropdown_7']"));
        countrySelect = new Select(country);
        WebElement month = driver.findElement(By.xpath("//select[@id='mm_date_8']"));
        monthSelect = new Select(month);
        WebElement day = driver.findElement(By.xpath("//select[@id='dd_date_8']"));
        daySelect = new Select(day);
        WebElement year = driver.findElement(By.xpath("//select[@id='yy_date_8']"));
        yearSelect = new Select(year);

        firstName = driver.findElement(By.xpath("//input[@id='name_3_firstname']"));
        lastName = driver.findElement(By.xpath("//input[@id='name_3_lastname']"));
        maritalStatus = driver.findElement(By.xpath("//input[@name='radio_4[]' and @value='married']"));
        hobby = driver.findElement(By.xpath("//input[@name='checkbox_5[]' and @value='dance']"));
        hobby2 = driver.findElement(By.xpath("//input[@name='checkbox_5[]' and @value='reading']"));
        phoneNumber = driver.findElement(By.xpath("//input[@id='phone_9']"));
        username = driver.findElement(By.xpath("//input[@id='username']"));
        email = driver.findElement(By.xpath("//input[@id='email_1']"));
        profilePicture = driver.findElement(By.xpath("//input[@type='file']"));
        aboutYourself = driver.findElement(By.xpath("//textarea[@id='description']"));
        password = driver.findElement(By.xpath("//input[@id='password_2']"));
        confirmPassword= driver.findElement(By.xpath("//input[@id='confirm_password_password_2']"));
        submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
    }

    @Test
    public void testRegistrationPage() throws InterruptedException {
        firstName.clear();
        firstName.sendKeys("Jasmine");
        lastName.clear();
        lastName.sendKeys("Jasminelastname");
        maritalStatus.click();
        hobby.click();
        countrySelect.selectByVisibleText("United States");
        monthSelect.selectByVisibleText("11");
        daySelect.selectByVisibleText("15");
        yearSelect.selectByVisibleText("1990");
        phoneNumber.clear();
        phoneNumber.sendKeys("011712334477");
        username.clear();
        username.sendKeys("jasmine1990");
        email.clear();
        email.sendKeys("jasmine@gmail.com");
        profilePicture.sendKeys("C:\\Users\\zveri\\IdeaProjects\\selenium_lab4\\jasmine.jpg");
        aboutYourself.clear();
        aboutYourself.sendKeys("Jasmine is an independent, fiery beauty capable of taking care of herself " +
                "who longs to experience life outside the palace");
        password.clear();
        password.sendKeys("Z1x2C3v4B5");
        confirmPassword.clear();
        confirmPassword.sendKeys("Z1x2C3v4B5");
        submitButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-49\"]/div/p")).isDisplayed());
        Thread.sleep(10000);
    }

    @Test
    public void testRegistrationPage2() throws InterruptedException {
        firstName.clear();
        firstName.sendKeys("Aladdin");
        lastName.clear();
        lastName.sendKeys("Aladdinlastname");
        maritalStatus.click();
        hobby2.click();
        countrySelect.selectByVisibleText("United States");
        monthSelect.selectByVisibleText("9");
        daySelect.selectByVisibleText("5");
        yearSelect.selectByVisibleText("1988");
        phoneNumber.clear();
        phoneNumber.sendKeys("011767334477");
        username.clear();
        username.sendKeys("aladdin1988");
        email.clear();
        email.sendKeys("alladin@gmail.com");
        profilePicture.sendKeys("C:\\Users\\zveri\\IdeaProjects\\selenium_lab4\\aladdin.jpeg");
        aboutYourself.clear();
        aboutYourself.sendKeys("Aladdin is portrayed as clever, and ultimately a good-hearted person");
        password.clear();
        password.sendKeys("123erty456");
        confirmPassword.clear();
        confirmPassword.sendKeys("123erty456");
        submitButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-49\"]/div/p")).isDisplayed());
        Thread.sleep(10000);
    }

    @Test
    public void testRegistrationPage3() throws InterruptedException {
        firstName.clear();
        firstName.sendKeys("Genie");
        lastName.clear();
        lastName.sendKeys("Genielastname");
        maritalStatus.click();
        hobby.click();
        countrySelect.selectByVisibleText("Cuba");
        monthSelect.selectByVisibleText("6");
        daySelect.selectByVisibleText("3");
        yearSelect.selectByVisibleText("1970");
        phoneNumber.clear();
        phoneNumber.sendKeys("0536677889");
        username.clear();
        username.sendKeys("genie1970");
        email.clear();
        email.sendKeys("genie@gmail.com");
        profilePicture.sendKeys("C:\\Users\\zveri\\IdeaProjects\\selenium_lab4\\genie.jpg");
        aboutYourself.clear();
        aboutYourself.sendKeys(" He is shown to have unlimited shapeshifting abilities, " +
                "which allow for many and varied sight gags");
        password.clear();
        password.sendKeys("123ertyOIU");
        confirmPassword.clear();
        confirmPassword.sendKeys("123ertyOIU");
        submitButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-49\"]/div/p")).isDisplayed());
        Thread.sleep(10000);
    }

    @AfterTest
    public void close() {
        driver.close();
    }

}