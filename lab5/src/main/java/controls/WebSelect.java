package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class WebSelect extends WebTypifiedElement{
    public WebSelect(WebElement wrappedElement) {
        super(wrappedElement);
    }

    private static final Logger log = LogManager.getLogger(WebSelect.class);

    private org.openqa.selenium.support.ui.Select getSelect() {
        return new Select(getWrappedElement());
    }

    public void selectByValue(String value) {
        log.debug("Selecting by value: " + value);
        getSelect().selectByValue(value);
    }
    public void selectByVisibleText(String text) {
        log.debug("Selecting by visible text: " + text);
        getSelect().selectByVisibleText(text);
    }
    public void selectByIndex(int index) {
        log.debug("Selecting by index: " + index);
        getSelect().selectByIndex(index);
    }
}
