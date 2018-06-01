package poms;

import controls.WebTextBlock;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PreviewPage extends AbstractPOM {
    public PreviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[@class='entry-title']")
    public WebTextBlock titleBlock;
    @FindBy(xpath = "//div[@class='entry-content']/p")
    public WebTextBlock textBlock;

    public void preview(String title, String text) {
        titleBlock.equals(title);
        textBlock.equals(text);
    }

    public void validateEdit(String newTitle, String newText) {
       titleBlock.equals(newTitle);
       textBlock.equals(newText);
    }
}
