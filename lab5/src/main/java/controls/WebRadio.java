package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class WebRadio extends WebTypifiedElement{
    private static final Logger log = LogManager.getLogger(WebRadio.class);
    public WebRadio(WebElement wrappedElement) {
        super(wrappedElement);
    }    public void click() {
        getWrappedElement().click();
        log.debug("Checked " + getName() + " radiobutton.");
    }
}
