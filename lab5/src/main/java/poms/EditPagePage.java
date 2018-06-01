package poms;

import controls.WebButton;
import controls.WebTextBlock;
import controls.WebTextInput;
import core.AbstractPOM;
import core.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EditPagePage extends AbstractPOM{
    public EditPagePage(WebDriver driver) {
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
    @FindBy(xpath = "//*[@id='menu-pages']/ul/li[2]/a")
    public WebButton allPagesBtn;
    @FindBy(xpath = "//td[1]/strong/a")
    public WebTextBlock tablePresence;
    @FindBy(xpath = "//*[@id='date']/a/span[1]")
    public WebButton sortByDateBtn;
    @FindBy(xpath = "//*[@id='post-preview']")
    public WebButton previewBtn;
    @FindBy(xpath = "//a[@class='submitdelete']")
    public WebButton trashBtn;

    public void addNewPage(String title, String text) {
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

    public void checkPresence(String title) {
        allPagesBtn.click();
        sortByDateBtn.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tablePresence.equals(title);
    }
    public void deletePage(){
        Helpers.hoverClick(driver, tablePresence, trashBtn);
    }

    public boolean checkAbsence(String title) {
        return (!tablePresence.getText().equals(title));
    }
}
