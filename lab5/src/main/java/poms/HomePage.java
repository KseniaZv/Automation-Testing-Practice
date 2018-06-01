package poms;

import controls.WebButton;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPOM {
    @FindBy(xpath = "//*[@id='navbar-login-link']")
    public WebButton signIn;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}