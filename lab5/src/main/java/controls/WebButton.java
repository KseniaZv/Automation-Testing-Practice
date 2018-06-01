package controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebButton extends WebTypifiedElement{
    private static final Logger log = LogManager.getLogger(WebButton.class);
	public WebButton(WebElement wrappedElement) {
		super(wrappedElement);
	}
	public boolean isClickable (){
        log.debug("Checking if '" + getName() +"' element is clickable");
	    return (isEnabled()&&isDisplayed());
    }

	public void checkIfClickable() {
        Assert.assertTrue(isClickable());
	}
}
