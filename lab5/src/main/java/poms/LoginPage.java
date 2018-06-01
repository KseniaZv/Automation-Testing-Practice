package poms;

import controls.WebButton;
import controls.WebTextBlock;
import controls.WebTextInput;
import core.AbstractPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPOM {

    @FindBy(xpath = "//input[@id='usernameOrEmail']")
    public WebTextInput userNameInput;

    @FindBy(xpath = "//button[@class='button form-button is-primary']")
    public WebButton continueBtn;

    @FindBy(xpath = "//input[@id='password']")
    public WebTextInput passwordInput;

    @FindBy(xpath = "//div[@id='login_error']")
    public WebTextBlock errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String name, String pwd) {
        userNameInput.sendKeys(name);
        continueBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button form-button is-primary']")));
        passwordInput.sendKeys(pwd);
        continueBtn.click();
    }

}
