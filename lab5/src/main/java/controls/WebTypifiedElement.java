package controls;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import core.Helpers;

public class WebTypifiedElement extends TypifiedElement{

	private static final Logger log = LogManager.getLogger(WebTypifiedElement.class);
	
	public WebTypifiedElement(WebElement wrappedElement) {
		super(wrappedElement);
	}
	
	public void equals(String str) {
		checkIfDisplayed();
		log.debug("Check content coincidence for " + getName());
		Helpers.check2StringIfEquals(getText(), str, "Check element " + getName() + " for equals");
	}

	@Override
	public void click() {
		log.debug("Click on element " + getName());
		getWrappedElement().click();
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		StringBuilder sb = new StringBuilder();
		for(CharSequence cs : keysToSend) {
			sb.append(cs);
		}
		getWrappedElement().clear();
		getWrappedElement().sendKeys(keysToSend);
		log.debug("Sendkeys for element " + getName() + "\nCompare\nActual \t: "+ getText() + "\nExpected: " + sb.toString() + "\n");
		Assert.assertTrue(StringUtils.equals(getText(), sb.toString()), "Validate entered test");
	}

	public void checkIfDisplayed() {
		Assert.assertTrue(isDisplayed(), "Element " + getName() + " is displayed");
		log.debug("Element " + getName() + " is displayed");
	}
}
