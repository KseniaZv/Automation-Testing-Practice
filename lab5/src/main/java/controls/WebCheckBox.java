package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class WebCheckBox extends WebTypifiedElement{
    private static final Logger log = LogManager.getLogger(WebCheckBox.class);

    public WebCheckBox(WebElement wrappedElement) {
        super(wrappedElement);
    }
    public void click() {
        getWrappedElement().click();
        log.debug("Clicked " + getName() + " checkbox.");
    }

    public void select() {
        if (!getWrappedElement().isSelected()) {
           click();
            log.debug("Checked " + getName() + " checkbox.");
        } else log.debug(getName() + " is already selected.");
    }

    public void deselect() {
        if (getWrappedElement().isSelected()) {
            click();
            log.debug("Unchecked " + getName() + " checkbox.");
        } else log.debug(getName() + " is already deselected.");
    }
    public void set(boolean value) {
        log.debug("Setting " + getName() + " checkbox value to " + value + ".");
        if (value) {
            select();
        } else {
            deselect();
        }
    }
}
