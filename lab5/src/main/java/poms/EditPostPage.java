package poms;

import controls.WebButton;
import controls.WebTextBlock;
import controls.WebTextInput;
import core.AbstractPOM;
import core.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class EditPostPage extends AbstractPOM{
    public EditPostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='title']")
    public WebTextInput titleInput;
    @FindBy(xpath = "//button[@id='content-html']")
    public WebButton textBtn;
    @FindBy(xpath = "//textarea[@class='wp-editor-area']")
    public WebTextInput textInput;
    @FindBy(xpath = "//input[@id='publish']")
    public WebButton publishBtn;
    @FindBy(xpath = "//*[@id='message']")
    public WebTextBlock publishedMsg;
    @FindBy(xpath = "//*[@id='menu-posts']/ul/li[2]/a")
    public WebButton allPostsBtn;
    @FindBy(xpath = "//td[1]/strong/a")
    public WebTextBlock tablePresence;
    @FindBy(xpath = "//*[@id='save-post']")
    public WebButton saveDraft;
    @FindBy(xpath = "//span[@class='post-state']")
    public WebTextBlock draftText;
    @FindBy(xpath = "//span[@class='edit']/a")
    public WebButton editBtn;
    @FindBy(xpath = "//span[@class='view']/a")
    public WebButton viewBtn;

    public void addNewPost(String title, String text) {
        titleInput.click();
        titleInput.sendKeys(title);
        textBtn.click();
        textInput.sendKeys(text);
    }

    public void publish() throws InterruptedException {
        Thread.sleep(1000);
        publishBtn.click();
        Thread.sleep(1000);
        publishedMsg.checkIfDisplayed();
    }

    public void saveDraft() throws InterruptedException {
        Thread.sleep(1000);
        saveDraft.click();
        Thread.sleep(1000);
        publishedMsg.checkIfDisplayed();
    }

    public void checkPresence(String title) {
        allPostsBtn.click();
        tablePresence.equals(title);
    }

    public void checkDraftPresence(String title) {
        checkPresence(title);
        draftText.equals("Draft");
    }

    public String getNameIfExists() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (tablePresence.exists()) {
            return tablePresence.getText();
        } else
            return null;
    }

    public boolean editValidatePost(String title, String text) throws InterruptedException {
        Helpers.hoverClick(driver, tablePresence, editBtn);
        Thread.sleep(1000);
        if (!(title.equals(titleInput.getText()) && text.equals(textInput.getText()))) {
            titleInput.click();
            titleInput.sendKeys(title);
            textBtn.click();
            textInput.sendKeys(text);
            publish();
            allPostsBtn.click();
            Thread.sleep(1000);
            Helpers.hoverClick(driver, tablePresence, viewBtn);
            return true;
        }
        return false;
    }

    public String getCurrentTitle() {
        return titleInput.getText();
    }

    public String getCurrentText() {
        return textInput.getText();
    }
}