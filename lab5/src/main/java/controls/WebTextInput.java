package controls;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class WebTextInput extends WebTypifiedElement{
    private static final Logger log = LogManager.getLogger(WebTextInput.class);

    public WebTextInput(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public String getText() {
        log.debug("Getting text for " + getName() + " element");
        if (!getWrappedElement().getAttribute("value").equals("")) {
            return getWrappedElement().getAttribute("value");
        }
        return Optional.ofNullable(getWrappedElement().getText()).orElse("");
    }

    public String getClearCharSequence() {
        log.debug("Getting clear char sequence for " + getName() + " element");
        return StringUtils.repeat(Keys.DELETE.toString() + Keys.BACK_SPACE, getText().length());
    }
}
