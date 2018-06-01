package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class WebLink extends  WebTypifiedElement{
    private static final Logger log = LogManager.getLogger(WebLink.class);
    public WebLink(WebElement wrappedElement) {
        super(wrappedElement);
    }
    public String getReference() {
        log.debug("Getting reference for link " + getName() + "element");
        return getWrappedElement().getAttribute("href");
    }
    public void click() {
        getWrappedElement().click();
        log.debug("Clicked on " + getName() + " link.");
    }
}
