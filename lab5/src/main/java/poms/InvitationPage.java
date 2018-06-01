package poms;

import controls.WebButton;
import controls.WebSelect;
import controls.WebTextInput;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class InvitationPage extends AbstractPOM {
    public InvitationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='button is-primary']")
    public WebButton inviteBtnWhenNone;
    @FindBy(xpath = "//input[@id='usernamesOrEmails']")
    public WebTextInput emailInput;
    @FindBy(xpath = "//select[@id='role']")
    public WebSelect roleSelect;
    @FindBy(xpath = "//button[@class='button form-button is-primary']")
    public WebButton sendInvitation;
    @FindBy(xpath = "//*[@id='primary']/main/div[2]/div[1]/div[2]/a")
    public WebButton inviteBtnWhenSome;

    public void inviteUser(String email, String role) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        if(inviteBtnWhenNone.exists())
            inviteBtnWhenNone.click();
        else
            inviteBtnWhenSome.click();
        emailInput.sendKeys(email);
        roleSelect.selectByValue(role);
        Thread.sleep(1000);
        sendInvitation.click();
        Thread.sleep(1000);
}
}
