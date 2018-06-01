package poms;

import controls.WebButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import controls.WebTextBlock;
import core.AbstractPOM;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends AbstractPOM {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@id='wp-admin-bar-my-account']")
    public WebButton accountBtn;

    @FindBy(xpath = "//*[@id='wp-admin-bar-user-info']/div/form/button")
    public WebButton signOutBtn;

    @FindBy(xpath = "//div[@class='wrap']/h1")
    public WebTextBlock pageTitle;

    @FindBy(xpath = "//div[@id='welcome']//h2")
    public WebTextBlock welcomeMsg;

    @FindBy(xpath = "//*[@id='menu-posts']/a/div[3]")
    public WebButton postBtn;

    @FindBy(xpath = "//a[@class='page-title-action']")
    public WebButton addNewPostBtn;

    @FindBy(xpath = "//*[@id='menu-pages']/a/div[3]")
    public WebButton pageBtn;

    @FindBy(xpath = "//a[@class='page-title-action']")
    public WebButton addNewPageBtn;
    
    @FindBy(xpath = "//*[@id='menu-users']/a/div[3]")
    public WebButton userBtn;

    @FindBy(xpath = "//a[@class='page-title-action']")
    public WebButton addNewUserBtn;

    public void addNewPage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        pageBtn.click();
        wait.until(
                ExpectedConditions.elementToBeClickable(addNewPageBtn)
        );
        addNewPageBtn.click();
    }

    public void addNewPost(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        postBtn.click();
        wait.until(
                ExpectedConditions.elementToBeClickable(addNewPostBtn)
        );
        addNewPostBtn.click();
    }

    public void signOut(WebDriver webDriver) {
        accountBtn.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(
                ExpectedConditions.elementToBeClickable(signOutBtn));
        signOutBtn.click();
    }

}
